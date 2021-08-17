package com.yu.common

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author   :   yuxibing
 * @date   :   2021/7/19
 * Describe : 扩展属性、方法等
 */

/**
 * 使用Float的扩展属性，将float类型的dp转为px
 */
val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )