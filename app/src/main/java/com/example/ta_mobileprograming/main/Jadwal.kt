package com.example.ta_mobileprograming.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ta_mobileprograming.detail.DetailActivity
import com.example.ta_mobileprograming.model.DataRequest
import com.example.ta_mobileprograming.network.ApiRepository
import com.example.ta_mobileprograming.network.ApiRepository2
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class Jadwal : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var datas: MutableList<DataRequest> = mutableListOf()
    private lateinit var listData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        frameLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(5)


            listData = recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = GridLayoutManager(ctx, 1)

            }

        }
        adapter = MainAdapter(datas) {
            startActivity<DetailActivity>(
                "NAMA_MAKUL" to it.nama_mk,
                "KODE_MAKUL" to it.kode_mk,
                "NAMA_DOSEN" to it.nama_dosen,
                "RUANG" to it.nama_ruang,
                "WAKTU" to it.waktu,
                "SKS1" to it.sks1,
                "KODE_KELAS" to it.kode_kelas)



        }

        listData.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), ApiRepository2(), Gson())
        presenter.getData()

    }

    override fun showData(data: List<DataRequest>) {
        datas.clear()
        datas.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
