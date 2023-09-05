package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Users (
    @SerializedName("id"         ) var id         : Int?     = null,
    @SerializedName("firstName"  ) var firstName  : String?  = null,
    @SerializedName("lastName"   ) var lastName   : String?  = null,
    @SerializedName("maidenName" ) var maidenName : String?  = null,
    @SerializedName("age"        ) var age        : Int?     = null,
    @SerializedName("gender"     ) var gender     : String?  = null,
    @SerializedName("email"      ) var email      : String?  = null,
    @SerializedName("phone"      ) var phone      : String?  = null,
    @SerializedName("username"   ) var username   : String?  = null,
    @SerializedName("password"   ) var password   : String?  = null,
    @SerializedName("birthDate"  ) var birthDate  : String?  = null,
    @SerializedName("image"      ) var image      : String?  = null,
    @SerializedName("bloodGroup" ) var bloodGroup : String?  = null,
    @SerializedName("height"     ) var height     : Int?     = null,
    @SerializedName("weight"     ) var weight     : Double?  = null,
    @SerializedName("eyeColor"   ) var eyeColor   : String?  = null,
//    @SerializedName("hair"       ) var hair       : Hair?    = Hair(),
    @SerializedName("domain"     ) var domain     : String?  = null,
    @SerializedName("ip"         ) var ip         : String?  = null,
//    @SerializedName("address"    ) var address    : Address? = Address(),
    @SerializedName("macAddress" ) var macAddress : String?  = null,
    @SerializedName("university" ) var university : String?  = null,
//    @SerializedName("bank"       ) var bank       : Bank?    = Bank(),
//    @SerializedName("company"    ) var company    : Company? = Company(),
    @SerializedName("ein"        ) var ein        : String?  = null,
    @SerializedName("ssn"        ) var ssn        : String?  = null,
    @SerializedName("userAgent"  ) var userAgent  : String?  = null
        )