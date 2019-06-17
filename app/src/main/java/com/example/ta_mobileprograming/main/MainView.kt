package com.example.ta_mobileprograming.main

import com.example.ta_mobileprograming.model.DataRequest

interface MainView{
    fun showData(data: List<DataRequest>)
}