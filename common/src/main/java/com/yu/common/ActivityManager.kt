package com.yu.common

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

/**
 * @author   :   yuxibing
 * @date   :   2021/6/10
 * Describe : Activity栈管理，可以监听Activity是否在前后台,以及获取栈顶的activity
 */
class ActivityManager private constructor() {

    private val activityRefs = ArrayList<WeakReference<Activity>>()
    private val frontBackCallBack = ArrayList<FrontBackCallback>()
    private var activityStartCount = 0
    private var front = true //默认在前台

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(InnerActivityLifecycleCallbacks())
    }

    interface FrontBackCallback {
        fun onChanged(front: Boolean)
    }

    fun addFrontBackCallback(callBack: FrontBackCallback) {
        frontBackCallBack.add(callBack)
    }

    fun removeFrontBackCallback(callBack: FrontBackCallback) {
        frontBackCallBack.remove(callBack)
    }

    inner class InnerActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activityRefs.add(WeakReference(activity))
        }

        override fun onActivityStarted(activity: Activity) {
            activityStartCount++
            // activityStartCount >0 说明应用处在可见状态，也就是前台
            // !front 之前在后台
            if (!front && activityStartCount > 0) {
                front = true
                onFrontBackChanged(front)

            }
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStopped(activity: Activity) {
            activityStartCount--
            if (activityStartCount <= 0 && front) {
                front = false
                onFrontBackChanged(front)
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            for (activityRef in activityRefs) {
                if (activityRef != null && activityRef.get() == activity) {
                    activityRefs.remove(activityRef)
                    break
                }
            }
        }

    }

    private fun onFrontBackChanged(front: Boolean) {
        for (callback in frontBackCallBack) {
            callback.onChanged(front)
        }
    }

    val topActivity: Activity?
        get() {
            if (activityRefs.size <= 0) {
                return null
            } else {
                return activityRefs[activityRefs.size - 1].get()
            }
        }


    companion object {
        val instance: ActivityManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ActivityManager()
        }
    }
}


