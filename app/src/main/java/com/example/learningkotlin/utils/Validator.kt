package com.example.learningkotlin.utils

import android.text.TextUtils
import com.example.learningkotlin.data.models.Contact

/**
 * Created by mateus on 10/11/16.
 */
class Validator {
    companion object {
        fun validateContactName(name: String?): Boolean {
            return !TextUtils.isEmpty(name)
        }

        fun validateContactAge(age: String?): Boolean {
            if (TextUtils.isEmpty(age)) {
                return false
            }
            try {
                val number = age!!.toInt()
                return number > 0 && number < 1000
            } catch (e: NumberFormatException) {
                return false
            }
        }

        fun validateContactSex(sex: String?): Boolean {
            if (TextUtils.isEmpty(sex)) {
                return false
            }
            try {
                Contact.Sex.valueOf(sex!!)
                return true
            } catch (e: IllegalArgumentException) {
                return false
            }
        }
    }
}