package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SingleUserBinding
import com.example.myapplication.model.Users

class UsersAdapter (private val users: List<Users>,private val listener: OnClickListener):
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = SingleUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersAdapter.ViewHolder, position: Int) {
        holder.binding.firstname.text = users[position].firstName
        holder.binding.lastname.text = users[position].lastName
        holder.binding.mainlyt.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }

    class ViewHolder(val binding: SingleUserBinding) : RecyclerView.ViewHolder(binding.root) {}


}