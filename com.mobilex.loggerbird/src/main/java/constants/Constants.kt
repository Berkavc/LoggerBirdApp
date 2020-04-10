package constants

import java.lang.StringBuilder

//Constant class.
internal class Constants {
    companion object {
        //Static global constant variables.
        const val componentTag = "component"
        const val recyclerViewTag = "recyclerView"
        const val activityTag = "activity"
        const val lifeCycleTag = "life_cycle"
        const val fragmentTag = "fragment"
        const val analyticsTag = "analytics"
        const val fragmentManagerTag = "fragmentManager"
        const val fragmentLifeCycleObserverTag = "fragmentLifeCycleObserver"
        const val activityLifeCycleObserverTag = "activityLifeCycleObserver"
        const val httpTag = "http"
        const val okHttpTag = "okHttp"
        const val inAPurchaseTag = "in_a_purchase"
        const val retrofitTag = "retrofit"
        const val realmTag = "realm"
        const val exceptionTag = ""
        const val emailTag = "email"
        const val unHandledExceptionTag = "Unhandled Exception"
        const val logInitErrorMessage = "Call logInit method before calling any other method!"
        const val logInitAttachedErrorMessage =
            "logInit method is already attached to your application!"
        const val internetErrorMessage = "Invalid internet connection response code!"
        const val networkErrorMessage = "Invalid network response"
        const val SMTP_HOST_NAME: String = "smtp.gmail.com";
        const val exceedFileLimitTag: String = "Exceed File Limit"
        const val saveSessionOldFileTag: String = "Save Session Old File"
        const val workQueueUtilTag: String = "Work Queue Util"
        const val recyclerViewAdapterDataObserverTag: String = "RecyclerView Adapter Data Observer"
        const val recyclerViewChildAttachStateChangeListenerTag: String =
            "RecyclerView Child Attach State Change Listener"
        const val recyclerViewItemTouchListener: String = "RecyclerView Item Touch Listener"
        const val recyclerViewScrollListener: String = "RecyclerView Scroll Listener"
        const val serviceTag: String = "Service"
        const val performanceTag: String = "Performance"
        const val memoryUsageTag = "Memory Usage"
        const val cpuTag: String = "Cpu"
        const val screenShotTag:String = "Screenshot"
        const val floatingActionButtonTag:String="Floating Action Button"
        const val floatingActionButtonOnTouchTag:String="Floating Action Button On Touch"
        const val audioRecordingTag:String="Audio Recording"
        const val audioStartRecordingTag:String="Audio Start Recording"
        const val audioStopRecordingTag:String="Audio Stop recording"
        const val videoRecordingTag:String="Video Recording"
        const val videoRecordingSdkTag:String="Call requires API level 21"
        const val foregroundServiceVideo:String = "Foreground Service Video"
        const val onActivityResultTag:String = "onActivityResult"
        const val onPermissionResultTag:String = "onPermissionResult"
        const val floatingActionButtonScreenshotTag:String = "Floating Action Button Screenshot"
        const val floatingActionButtonVideoTag:String = "Floating Action Button Video"
        const val floatingActionButtonAudioTag:String = "Floating Action Button Audio"
    }
}