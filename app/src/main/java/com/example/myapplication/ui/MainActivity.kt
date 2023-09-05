package com.example.myapplication.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.UsersAdapter
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Users
import com.example.myapplication.repository.UserRepository
import com.example.myapplication.viewmodel.MyViewModelFactory
import com.example.myapplication.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() ,UsersAdapter.OnClickListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var usersAdapter: UsersAdapter
    lateinit var userViewModel: UserViewModel
    private val apiInterface = ApiInterface.getInstance()
    var userList = mutableListOf<Users>()
    var limit = 30
    var skip = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory
        userViewModel =
            ViewModelProvider(this, MyViewModelFactory(UserRepository(apiInterface))).get(
                UserViewModel::class.java
            )

        binding.progress.visibility = View.VISIBLE
        userViewModel.getUser(limit,skip)

        userViewModel.userData.observe(this, Observer {

            userList = it.users
            usersAdapter = UsersAdapter(userList,this)
            binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.recycler.adapter = usersAdapter
            binding.progress.visibility = View.GONE
        })

        userViewModel.errorMessage.observe(this, Observer {
            binding.progress.visibility = View.GONE
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })



    }

    override fun onClick(position: Int) {

        val alertDialogBuilder = AlertDialog.Builder(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.user_details_dialog, null)

        val firstName = dialogView.findViewById<TextView>(R.id.firstname)
        val lastName = dialogView.findViewById<TextView>(R.id.lastname)
        val maiden = dialogView.findViewById<TextView>(R.id.maidenName)
        val age = dialogView.findViewById<TextView>(R.id.age)
        val gender = dialogView.findViewById<TextView>(R.id.gender)
        val mail = dialogView.findViewById<TextView>(R.id.email)
        val phone = dialogView.findViewById<TextView>(R.id.phone)
        val birthday = dialogView.findViewById<TextView>(R.id.bday)
        val eyecolor = dialogView.findViewById<TextView>(R.id.eyecolor)

        firstName.text = userList[position].firstName
        lastName.text = userList[position].lastName
        maiden.text = userList[position].maidenName
        age.text = userList[position].age.toString()
        gender.text = userList[position].gender
        mail.text = userList[position].email
        phone.text = userList[position].phone
        birthday.text = userList[position].birthDate
        eyecolor.text = userList[position].eyeColor

        alertDialogBuilder.setView(dialogView)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}