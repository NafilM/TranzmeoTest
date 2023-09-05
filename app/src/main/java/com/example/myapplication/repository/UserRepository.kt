package com.example.myapplication.repository

import com.example.myapplication.api.ApiInterface

class UserRepository constructor(private val apiInterface: ApiInterface) {

    fun getUsers(limit : Int,skip : Int) = apiInterface.getUsers(limit,skip)
}