package com.example.ta_mobileprograming.network

import com.example.ta_mobileprograming.BuildConfig.API_KEY
import com.example.ta_mobileprograming.BuildConfig.BASE_URL

object DataApi {
    fun getData():String{
        return BASE_URL + API_KEY
    }
}
