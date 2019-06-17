package com.example.ta_mobileprograming.network

import java.net.URL

class ApiRepository {
    fun doRequest(url:String): String{
        return URL(url).readText()
    }
}