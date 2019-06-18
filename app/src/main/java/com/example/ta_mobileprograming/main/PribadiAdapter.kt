package com.example.ta_mobileprograming.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ta_mobileprograming.R
import com.example.ta_mobileprograming.model.DataRequest
import com.example.ta_mobileprograming.R.id.TvNama as TvNama1
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
                textView {
                    id= TvNama1
                    textSize=20f
                    textColor=Color.BLACK
                }.lparams(height= wrapContent,width = matchParent)
            }
        }
    }
}
class DataViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
    private val Nama: TextView = view.find(TvNama1)
    fun bindItem1(datarequest: DataRequest, listener: (DataRequest) -> Unit){
        Nama.text = datarequest.nama
}
}
