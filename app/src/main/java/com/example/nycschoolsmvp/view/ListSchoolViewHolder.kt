package com.example.nycschoolsmvp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschoolsmvp.R
import com.example.nycschoolsmvp.model.NYClistSchoolResponse

class ListSchoolViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
   private val tvSchoolName:TextView = itemView.findViewById(R.id.tv_title_school_name)
    private val tvSchoolAdd:TextView = itemView.findViewById(R.id.tv_item_school_address)
    private val tvSchoolPhone:TextView = itemView.findViewById(R.id.tv_item_school_phone)


    fun onBind(dataItem: NYClistSchoolResponse,
    onClickCallback: (String)->Unit){
        tvSchoolName.text = dataItem.school_name
        tvSchoolAdd.text = dataItem.location
        tvSchoolPhone.text = dataItem.phone_number
        itemView.setOnClickListener { onClickCallback.invoke(dataItem.dbn) }

    }
}