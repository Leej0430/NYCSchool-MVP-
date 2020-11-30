package com.example.nycschoolsmvp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschoolsmvp.R
import com.example.nycschoolsmvp.model.NYClistSatResponse
import com.example.nycschoolsmvp.model.NYClistSchoolResponse
import org.w3c.dom.Text

class ListSatViewHolder(satView: View): RecyclerView.ViewHolder(satView) {
    private val tvSatName : TextView = satView.findViewById(R.id.tv_item_sat_name)
    private val tvSatNumber : TextView = satView.findViewById(R.id.tv_item_sat_test_takers)
    private val tvSatCritical : TextView = satView.findViewById(R.id.tv_item_sat_critical_reading)
    private val tvSatMath : TextView = satView.findViewById(R.id.tv_item_sat_math_avg)
    private val tvSatWriting : TextView = satView.findViewById(R.id.tv_item_sat_writing_avg)

    fun onBind(dataItem: NYClistSatResponse,
               onClickCallback: (String)->Unit){
        tvSatName.text = dataItem
    }
}