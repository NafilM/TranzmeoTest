package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.UsersResponse
import com.example.myapplication.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel (private val repository: UserRepository) : ViewModel(){

    val userData = MutableLiveData<UsersResponse>()
    val errorMessage = MutableLiveData<String>()
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    fun getUser(limit : Int,skip : Int) {
        viewModelScope.launch {
            try {
                val response = repository.getUsers(limit,skip)
                response.enqueue(object : Callback<UsersResponse> {
                    override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                        if (response.isSuccessful){
                            if (response.body() != null){
                                userData.postValue(response.body())
                            }else {
                                Log.e("response.body :  ","is null")
                            }

                        }else {
                            Log.e("api :  ","not isSuccessful")
                        }
                    }

                    override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                        Log.e("api :  ","onFailure")
                        errorMessage.postValue(t.message)
                    }
                })
            }catch (t: Throwable) {
                Log.e("api : ", "onFailure")
                t.printStackTrace()
            }
        }
    }

}