package com.example.nycschoolsmvp.presenter

import android.util.Log
import com.example.nycschoolsmvp.model.ListDataType
import com.example.nycschoolsmvp.model.NYClistSchoolResponse
import com.example.nycschoolsmvp.model.SchoolsLocal
import com.example.nycschoolsmvp.model.SchoolsNetwork
import com.example.nycschoolsmvp.view.IMainActivity
private val TAG ="MainActivityPresenter"
class MainActivityPresenter {

    private  var view: IMainActivity? = null
    private lateinit var schoolsNetwork: SchoolsNetwork
    private lateinit var schoolsLocal: SchoolsLocal

    fun bindView(view:IMainActivity){
        this.view = view
    }

    fun requestData(){
        //todo check if local is empty
        //todo update if local is not empty
        //todo send data from local
        if(view?.readLastNetworkCall().equals("N/A")){
            schoolsNetwork.initVolley ({
                //todo inform about errors on the Network Call
                Log.d(TAG,"requestData: network error $it")

            },{
                schoolsLocal.insertListSchools(it)
            })
        }
        else{
            schoolsLocal.readListSchools {
                updateViewData(it)
            }
        }
        //todo read from DB

    }
    private fun updateViewData(dataSet: List<NYClistSchoolResponse>){
        val schoolType: ListDataType.SCHOOLTYPE =
            ListDataType.SCHOOLTYPE(dataSet)
        view?.displayData(schoolType)
    }
    fun unBind(){
        view = null
    }

}