package com.example.mybestpractice.kotlin

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author   :   yuxibing
 * @date   :   2021/5/19
 * Describe :
 */
class Delegate :ReadWriteProperty<String,Int>{
    override fun setValue(thisRef: String, property: KProperty<*>, value: Int) {
        TODO("Not yet implemented")
    }

    override fun getValue(thisRef: String, property: KProperty<*>): Int {
        TODO("Not yet implemented")
    }

    /*val propValue: Any? = null
    operator fun  getValue(myclass:User,prop:KProperty<*>):Any?{
        return propValue
    }*/

}