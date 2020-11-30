package com.example.nycschoolsmvp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschoolsmvp.R
import com.example.nycschoolsmvp.model.NYClistSatResponse

class SatAdapter (val dataSet:List<NYClistSatResponse>, val activityCallback:(sat: NYClistSatResponse)->Unit)
    : RecyclerView.Adapter<SatAdapter.SatViewHolder>(){
    class SatViewHolder(satView: View)
        : RecyclerView.ViewHolder(satView){
        private  val schoolName : TextView
                =satView.findViewById(R.id.tv_item_sat_name)
        private  val testTaker : TextView
                =satView.findViewById(R.id.tv_item_sat_test_takers)
        private  val readingAvg : TextView
                =satView.findViewById(R.id.tv_item_sat_critical_reading)
        private  val mathAvg : TextView
                =satView.findViewById(R.id.tv_item_sat_math_avg)
        private  val writingAvg : TextView
                =satView.findViewById(R.id.tv_item_sat_writing_avg)
        fun onBind(
            dataItem: NYClistSatResponse,
            activityCallback: (sat: NYClistSatResponse) -> Unit
        )
        {
            schoolName.text = dataItem.school_name
            testTaker.text = dataItem.num_of_sat_test_takers
            readingAvg.text = dataItem.sat_critical_reading_avg_score
            mathAvg.text = dataItem.sat_math_avg_score
            writingAvg.text = dataItem.sat_writing_avg_score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatViewHolder {
        return SatViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_list_schools,parent,false))
    }

    override fun onBindViewHolder(holder: SatViewHolder, position: Int) {
       holder.onBind(dataSet[position],activityCallback)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }



}