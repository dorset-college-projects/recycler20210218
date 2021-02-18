package com.cairnfort.recycler0218

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cairnfort.recycler0218.models.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_row.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView_Main.setBackgroundColor(Color.YELLOW)

        //Add a layout
        recyclerView_Main.layoutManager = LinearLayoutManager(this)

        recyclerView_Main.adapter = MainAdapter()

    }

    class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {
        val users = listOf(
            User("John", 58),
            User("Peter", 27),
            User("Jane", 49)
        )
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
           // TODO("Not yet implemented")
            val layoutInflater = LayoutInflater.from(parent?.context)
            var cellForRow = layoutInflater.inflate(R.layout.user_row, parent, false)
            return CustomViewHolder(cellForRow)

        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //    TODO("Not yet implemented")
            holder.itemView.textView1.text = users[position].name
            holder.itemView.textView2.text = users[position].age.toString()

        }

        override fun getItemCount(): Int {
           // TODO("Not yet implemented")

            return users.size
        }

    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}