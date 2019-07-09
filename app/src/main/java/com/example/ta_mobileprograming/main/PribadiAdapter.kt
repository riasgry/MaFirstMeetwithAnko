package com.example.ta_mobileprograming.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ta_mobileprograming.BuildConfig.NPM
import com.example.ta_mobileprograming.BuildConfig.URL_FOTO
import com.example.ta_mobileprograming.R
import com.example.ta_mobileprograming.R.id.TvFoto
import com.example.ta_mobileprograming.model.DataRequest
import com.squareup.picasso.Picasso
import com.example.ta_mobileprograming.R.id.TvNama as TvNama1
import com.example.ta_mobileprograming.R.id.TvNpm as TvNpm1
import com.example.ta_mobileprograming.R.id.TvNik as TvNik1
import com.example.ta_mobileprograming.R.id.TvAlamat as TvAlamat1
import com.example.ta_mobileprograming.R.id.TvEmail as TvEmail1

import org.jetbrains.anko.*

class PribadiAdapter(private val result: List<DataRequest>, private val listener: (DataRequest) ->Unit)
    : RecyclerView.Adapter<DataViewHolder1>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder1 {
        return DataViewHolder1(PribadiUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: DataViewHolder1, position: Int) {
        holder.bindItem1(result[position], listener)
    }
}

class PribadiUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width= matchParent,height = wrapContent)
                orientation=LinearLayout.VERTICAL
                imageView {
                    id= TvFoto
                }.lparams(height= wrapContent,width = wrapContent)
                gravity = Gravity.CENTER
                textView {
                    text = "Nama"
                    textSize = 20f
                    gravity = Gravity.LEFT
                    background = ColorDrawable(Color.parseColor("#91897a"))
                    textColor = resources.getColor(android.R.color.black)
                }.lparams(height= wrapContent, width = matchParent){
                    topMargin=dip(10)
                }
                textView {
                    id= TvNama1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
                textView {
                    text = "NPM"
                    textSize = 20f
                    gravity = Gravity.LEFT
                    background = ColorDrawable(Color.parseColor("#91897a"))
                    textColor = resources.getColor(android.R.color.black)
                }.lparams(height= wrapContent, width = matchParent){
                    topMargin=dip(10)
                }

                textView {
                    id= TvNpm1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
                textView {
                    text = "NIK"
                    textSize = 20f
                    gravity = Gravity.LEFT
                    background = ColorDrawable(Color.parseColor("#91897a"))
                    textColor = resources.getColor(android.R.color.black)
                }.lparams(height= wrapContent, width = matchParent){
                    topMargin=dip(10)
                }

                textView {
                    id= TvNik1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
                textView {
                    text = "Alamat"
                    textSize = 20f
                    gravity = Gravity.LEFT
                    background = ColorDrawable(Color.parseColor("#91897a"))
                    textColor = resources.getColor(android.R.color.black)
                }.lparams(height= wrapContent, width = matchParent){
                    topMargin=dip(10)
                }

                textView {
                    id= TvAlamat1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
                textView {
                    text = "Email"
                    textSize = 20f
                    gravity = Gravity.LEFT
                    background = ColorDrawable(Color.parseColor("#91897a"))
                    textColor = resources.getColor(android.R.color.black)
                }.lparams(height= wrapContent, width = matchParent){
                    topMargin=dip(10)
                }

                textView {
                    id= TvEmail1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
            }
        }
    }
}
class DataViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
    private val Foto: ImageView = view.find(TvFoto)
    private val Nama: TextView = view.find(TvNama1)
    private val Npm : TextView = view.find(TvNpm1)
    private val Nik : TextView = view.find(TvNik1)
    private val Alamat : TextView = view.find(TvAlamat1)
    private val Email : TextView=view.find(TvEmail1)
    fun bindItem1(datarequest: DataRequest, listener: (DataRequest) -> Unit){
        Picasso.get().load(URL_FOTO+ NPM +".jpg").into(Foto)
        Nama.text = datarequest.nama
        Npm.text = datarequest.npm
        Nik.text = datarequest.nik
        Alamat.text = datarequest.almt
        Email.text = datarequest.email
}
}
