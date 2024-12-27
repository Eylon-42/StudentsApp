package com.efai.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.efai.studentsapp.model.Student


class MainActivity : AppCompatActivity() {

    private lateinit var studentsListRecyclerView: RecyclerView

    companion object {
        val studentsList = ArrayList<Student>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()


        studentsListRecyclerView = findViewById(R.id.studentList)
        studentsListRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpListeners() {
        val addButton: ImageView = findViewById(R.id.add)
        addButton.setOnClickListener {
            val intent = Intent(applicationContext, AddStudent::class.java)
            startActivity(intent)
        }
    }
}