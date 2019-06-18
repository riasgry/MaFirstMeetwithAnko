package com.example.ta_mobileprograming.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ta_mobileprograming.R
import com.example.ta_mobileprograming.R.id.TvButton
import com.example.ta_mobileprograming.R.id.center
import com.example.ta_mobileprograming.model.DataRequest
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*
import com.example.ta_mobileprograming.R.id.jam_makul as jam_makul1
import com.example.ta_mobileprograming.R.id.nama_dosen as nama_dosen1
import com.example.ta_mobileprograming.R.id.nama_makul as nama_makul1

class MainAdapter(private val result: List<DataRequest>, private val listener: (DataRequest) ->Unit)
    : RecyclerView.Adapter<DataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(DataUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.bindItem(result[position], listener)
      }

}

class DataUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
                linearLayout {
                    lparams{
                        topMargin = dip(20)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    background = ColorDrawable(Color.parseColor("#91897a"))

                    imageView {
                        imageResource = R.drawable.buku
                    }.lparams(width = dip(30), height = matchParent)
                    linearLayout {
                        orientation = LinearLayout.VERTICAL
                        textView {
                            textSize = dip(8).toFloat()
                            //android:fontFamily = sans-serif-medium //not support attribute
                            gravity = Gravity.CENTER
                            text = "Nama MK"
                            id = nama_makul1
                            textColor = Color.BLACK
                        }.lparams(width = matchParent)
                        textView {
                            textSize = dip(5).toFloat()
                            //android:fontFamily = sans-serif-medium //not support attribute
                            gravity = Gravity.CENTER
                            text = "Nama Dosen"
                            id = nama_dosen1
                            textColor = resources.getColor(android.R.color.darker_gray)
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent) {
                        weight = 1f
                    }
                    textView {
                        textSize = dip(5).toFloat()
                        //android:fontFamily = sans-serif-medium //not support attribute
                        gravity = Gravity.CENTER
                        text = "MINGGU 14:30 GP 601"
                        id = jam_makul1
                        textColor = resources.getColor(android.R.color.holo_red_light)
                    }.lparams(width = dip(70), height = matchParent)
                    view {
                        backgroundColor = resources.getColor(R.color.colorPrimary)
                    }.lparams(width = dip(5), height = matchParent)
                }
            }
        }


            }

class DataViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val namaMakul: TextView = view.find(nama_makul1)
    private val namaDosen: TextView = view.find(nama_dosen1)
    var Hari: String?=null
    private val jamMakul: TextView = view.find(jam_makul1)
    var namaHari: String? = null
    fun bindItem(datarequest: DataRequest, listener: (DataRequest) -> Unit){

        namaMakul.text = datarequest.nama_mk
        namaDosen.text = datarequest.nama_dosen
        Hari= datarequest.hari
        if (Hari!!.equals("1")) {
            namaHari = "Senin"
        } else if (Hari!!.equals("2")) {
            namaHari = "Selasa"
        } else if (Hari!!.equals("3")) {
            namaHari = "Rabu"
        } else if (Hari!!.equals("4")) {
            namaHari = "Kamis"
        } else if (Hari!!.equals("5")) {
            namaHari = "Jum'at"
        } else if (Hari!!.equals("6")) {
            namaHari = "Sabtu"
        } else if (Hari!!.equals("7")) {
            namaHari = "Minggu"
        }
        jamMakul.text = namaHari + "," + datarequest.waktu + ","  + datarequest.nama_ruang

        namaMakul.onClick {
            listener(datarequest)
        }
    }
}