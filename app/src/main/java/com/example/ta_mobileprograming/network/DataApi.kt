package com.example.ta_mobileprograming.network

import com.example.ta_mobileprograming.BuildConfig.*

object DataApi {
    fun getData():String{

        return BASE_URL + API_KEY + NPM
    }
    fun getPribadi():String{

        return BASE_URL_DATA + API_KEY + NPM
    }
}
