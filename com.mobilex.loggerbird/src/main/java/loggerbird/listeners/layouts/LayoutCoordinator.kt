package loggerbird.listeners.layouts

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import loggerbird.services.LoggerBirdService
import java.util.*

internal class LayoutCoordinator(context: Context) : FrameLayout(context) {
    private var controlVolumeUp: Boolean = false
    private var controlVolumeDown: Boolean = false
    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        if(event?.action == KeyEvent.ACTION_DOWN){
            volumeTimer()
            when (event.keyCode) {
                KeyEvent.KEYCODE_VOLUME_UP -> controlVolumeUp = true
                KeyEvent.KEYCODE_VOLUME_DOWN -> controlVolumeDown = true
            }
            if (controlVolumeUp && controlVolumeDown) {
                LoggerBirdService.loggerBirdService.initializeLoggerBirdLayoutAction()
                controlVolumeUp = false
                controlVolumeDown = false
            }
        }
        return super.dispatchKeyEvent(event)
    }
    /**
     * This method is used for arrange the time that user have to click volume-up and volume-down keys.
     */
    private fun  volumeTimer() {
        val timerToast = Timer()
        val timerTaskToast = object : TimerTask() {
            override fun run() {
                controlVolumeUp = false
                controlVolumeDown = false
            }
        }
        timerToast.schedule(timerTaskToast, 1000)
    }
}