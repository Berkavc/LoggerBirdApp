package loggerbird.observers

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.mobilex.loggerbird.R
import loggerbird.LoggerBird
import loggerbird.constants.Constants
import loggerbird.listeners.layouts.LayoutOnTouchListener
import kotlin.collections.ArrayList

internal class LogComponentObserver {
    private  var viewLoggerBirdCoordinator: View? = null
    private val arrayListComponentViews: ArrayList<View> = ArrayList()
    private lateinit var layoutOnTouchActivityListener: LayoutOnTouchListener
    private lateinit var layoutOnTouchFragmentListener: LayoutOnTouchListener
    @SuppressLint("ClickableViewAccessibility")
    internal fun initializeLoggerBirdCoordinatorLayout(
        activity: Activity? = null,
        fragment: Fragment? = null
    ) {
        try {
            if (activity != null) {
                val layoutInflater: LayoutInflater =
                    (activity.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                viewLoggerBirdCoordinator = layoutInflater.inflate(
                    R.layout.loggerbird_coordinator,
                    activity.window.decorView.findViewById(android.R.id.content),
                    false
                )
                if(viewLoggerBirdCoordinator != null){
                    (activity.window.decorView.findViewById(android.R.id.content) as ViewGroup).addView(viewLoggerBirdCoordinator)
                    val frameLayout =
                        viewLoggerBirdCoordinator!!.findViewById<FrameLayout>(R.id.logger_bird_coordinator)
                    layoutOnTouchActivityListener = LayoutOnTouchListener(activity = activity)
                    frameLayout.setOnTouchListener(layoutOnTouchActivityListener)
                    frameLayout.viewTreeObserver.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
                        override fun onGlobalLayout() {
                            gatherComponentViews(activity = activity)
                            frameLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        }
                    })
                }
            } else if (fragment != null) {
                if(fragment.view != null){
                    val layoutInflater: LayoutInflater =
                        (fragment.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    viewLoggerBirdCoordinator = layoutInflater.inflate(
                        R.layout.loggerbird_coordinator,
                        (fragment.view as ViewGroup),
                        false
                    )
                    if(viewLoggerBirdCoordinator != null){
                        (fragment.view as ViewGroup).addView(viewLoggerBirdCoordinator)
                        val frameLayout =
                            viewLoggerBirdCoordinator!!.findViewById<FrameLayout>(R.id.logger_bird_coordinator)
                        layoutOnTouchFragmentListener = LayoutOnTouchListener(fragment = fragment)
                        frameLayout.setOnTouchListener(layoutOnTouchFragmentListener)
                        frameLayout.viewTreeObserver.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
                            override fun onGlobalLayout() {
                                gatherComponentViews(fragment = fragment)
                                frameLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                            }
                        })
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoggerBird.callEnqueue()
            LoggerBird.callExceptionDetails(exception = e, tag = Constants.componentObserverTag)
        }
    }

    internal fun removeLoggerBirdCoordinatorLayout(
        activity: Activity? = null,
        fragment: Fragment? = null
    ) {
            if(viewLoggerBirdCoordinator != null){
                if(viewLoggerBirdCoordinator!!.parent != null){
                    if (activity != null) {
                        (activity.window.decorView.findViewById(android.R.id.content) as ViewGroup).removeView(viewLoggerBirdCoordinator)
//                        activity.windowManager.removeViewImmediate(viewLoggerBirdCoordinator)
                    } else if (fragment != null) {
                        (fragment.view as ViewGroup).removeView(viewLoggerBirdCoordinator)
                    }
                    viewLoggerBirdCoordinator = null
                }
            }
    }

    private fun gatherComponentViews(activity: Activity? = null, fragment: Fragment? = null) {
        try {
            arrayListComponentViews.clear()
            if (activity != null) {
//                (activity.window.decorView as ViewGroup).getAllViews().forEach {
//                    if (it !is ViewGroup) {
//                        arrayListComponentViews.add(it)
//                    }
//                }
                recursiveViews(view = activity.window.decorView)
                LogActivityLifeCycleObserver.hashMapActivityComponents[activity] =
                    arrayListComponentViews
            } else if (fragment != null) {
//                (fragment.view as ViewGroup).getAllViews().forEach {
//                    if (it !is ViewGroup) {
//                        arrayListComponentViews.add(it)
//                    }
//                }
                recursiveViews(view = fragment.requireView())
                LogFragmentLifeCycleObserver.hashMapFragmentComponents[fragment] =
                    arrayListComponentViews
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoggerBird.callEnqueue()
            LoggerBird.callExceptionDetails(exception = e, tag = Constants.componentObserverTag)
        }
    }

    private fun View.getAllViews(): List<View> {
        if (this !is ViewGroup || childCount == 0) return listOf(this)
        return children
            .toList()
            .flatMap { it.getAllViews() }
            .plus(this as View)
    }

    private fun recursiveViews(view: View) {
        if(!arrayListComponentViews.contains(view)){
            arrayListComponentViews.add(view)
        }
        if (view is ViewGroup) {
                for(childCounter in 0 .. view.childCount){
                    if(view.getChildAt(childCounter) != null){
                        recursiveViews(view = view.getChildAt(childCounter))
                    }
                }
        }
    }
}