package com.example.roomdb.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.R
import com.example.roomdb.model.UserEntity
import com.example.roomdb.update.Update
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.listuser.view.*

class ListAdapter(var context: Context) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<UserEntity>()
    lateinit var userViewModel: UserViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.listuser, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var currentItem = userList[position]
        holder.itemView.text_name.text = currentItem.name + currentItem.lastname
        holder.itemView.text_email.text = currentItem.email
        holder.itemView.text_phone.text = currentItem.phone
        holder.itemView.cardview.setOnClickListener {
            val intent = Intent(context, Update::class.java)
            intent.putExtra("id", currentItem.id)
            intent.putExtra("name", currentItem.name)
            intent.putExtra("lastname", currentItem.lastname)
            intent.putExtra("email", currentItem.email)
            intent.putExtra("phone", currentItem.phone)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<UserEntity>) {
        this.userList = user
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}