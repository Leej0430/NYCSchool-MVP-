package com.example.nycschoolsmvp.model

sealed class ListDataType {
    data class SCHOOLTYPE(val data: List<NYClistSchoolResponse>)
        : ListDataType()

    data class SATTYPE(val data: NYClistSatResponse)
        :ListDataType()

}