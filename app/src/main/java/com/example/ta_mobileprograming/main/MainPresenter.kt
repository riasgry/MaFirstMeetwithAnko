package com.example.ta_mobileprograming.main

import android.text.method.MovementMethod
import com.example.ta_mobileprograming.model.DataResponse
import com.example.ta_mobileprograming.network.ApiRepository
import com.example.ta_mobileprograming.network.DataApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view:MainView, private val apiRepository: ApiRepository, private val gson: Gson){
    fun getData(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(DataApi.getData()),
                DataResponse::class.java)
            uiThread {
                view.showData(data.data)
            }
        }
    }
}