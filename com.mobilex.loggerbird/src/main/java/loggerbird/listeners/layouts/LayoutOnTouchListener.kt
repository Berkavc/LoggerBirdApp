package loggerbird.listeners.layouts

import android.app.Activity
import android.graphics.Rect
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import loggerbird.LoggerBird
import loggerbird.constants.Constants
import loggerbird.observers.LogActivityLifeCycleObserver
import loggerbird.observers.LogFragmentLifeCycleObserver
import java.text.SimpleDateFormat
import java.util.*


//This class is used for observing components in the current view.
internal class LayoutOnTouchListener(
    private val activity: Activity? = null, private val fragment: Fragment? = null
) : View.OnTouchListener {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private var formattedTime: String? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        try {
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat.getDateTimeInstance()
            formattedTime = formatter.format(date)
            Log.d("touch_x", event.rawX.toString())
            Log.d("touch_y", event.rawY.toString())
            if (activity != null) {
                LogActivityLifeCycleObserver.hashMapActivityComponents[activity]?.forEach {
                    if (it !is ViewGroup) {
                        val rect = Rect(it.left, it.top, it.right, it.bottom)
                        if (rect.contains(event.x.toInt(), event.y.toInt())) {
                     Log.d("touch_clicked_activity", "Id:" + it.id + "\n" + it.toString())
                            LoggerBird.stringBuilderActivityLifeCycleObserver.append(Constants.activityTag + ":" + activity.javaClass.simpleName + " " + "$formattedTime" + " "  + "Component Id:" + it.id + "  " + "Component Name:" + it.toString() + "\n")
                        }
                    }
                }
            } else if (fragment != null) {
                val className: String = if (fragment.tag != null) {
                    fragment.tag!!
                } else {
                    fragment.javaClass.simpleName
                }
                LogFragmentLifeCycleObserver.hashMapFragmentComponents[fragment]?.forEach {
                    if (it !is ViewGroup) {
                        val rect = Rect(it.left, it.top, it.right, it.bottom)
                        if (rect.contains(event.x.toInt(), event.y.toInt())) {
                        Log.d("touch_clicked_fragment", "Id:" + it.id + "\n" + it.toString())
                            LogFragmentLifeCycleObserver.stringBuilderFragmentLifeCycleObserver.append(
                                Constants.fragmentTag + ":" + className + " " + "$formattedTime" + " " + "Component Id:" + it.id  + "Component Name:" + it.toString() + "\n"
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoggerBird.callEnqueue()
            LoggerBird.callExceptionDetails(
                exception = e,
                tag = Constants.layoutOnTouchTag
            )
        }
        return false
    }
}
