package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("users" ) var users : ArrayList<Users> = arrayListOf(),
    @SerializedName("total" ) var total : Int?             = null,
    @SerializedName("skip"  ) var skip  : Int?             = null,
    @SerializedName("limit" ) var limit : Int?             = null
        )