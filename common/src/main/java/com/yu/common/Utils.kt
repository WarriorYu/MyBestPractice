package com.yu.common

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author   :   yuxibing
 * @date   :   2021/7/19
 * Describe :
 */
class Utils {
    fun dp2px(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value,
            Resources.getSystem().displayMetrics
        )
    }
}