package com.example.learningkotlin.utils

import android.telephony.PhoneNumberUtils
import android.text.TextUtils

/**
 * Created by mateus on 10/11/16.
 */
class Validator {
    fun validateContactName(name: String?): Boolean {
        return !TextUtils.isEmpty(name)
    }

    fun validateContactEmail(email: String?): Boolean {
        return !TextUtils.isEmpty(email) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validateContactPhone(phone: String?): Boolean {
        return PhoneNumberUtils.isGlobalPhoneNumber(phone)
    }
}