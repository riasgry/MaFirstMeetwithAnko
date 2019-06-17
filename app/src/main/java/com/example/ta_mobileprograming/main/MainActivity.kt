package com.example.ta_mobileprograming.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import com.example.ta_mobileprograming.R
import com.example.ta_mobileprograming.detail.DetailActivity
import com.example.ta_mobileprograming.model.DataRequest
import com.example.ta_mobileprograming.network.ApiRepository
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var datas:MutableList<DataRequest> = mutableListOf()
    private lateinit var listData : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        frameLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(5)


            listData = recyclerView{
                lparams(width = matchParent, height = wrapContent)
                layoutManager = GridLayoutManager(ctx, 1)
            }
        }
        adapter= MainAdapter(datas){
            startActivity<DetailActivity>()
        }

        listData.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(),Gson())
        presenter.getData()
    }
    override fun showData(data: List<DataRequest>) {
        datas.clear()
        datas.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
