package com.efai.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.efai.studentsapp.model.Student
import com.efai.studentsapp.adapter.StudentsAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var studentsListRecyclerView: RecyclerView

    companion object {
        lateinit var studentsAdapter: StudentsAdapter
        val studentsList = ArrayList<Student>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Students List"
        setUpListeners()


        studentsListRecyclerView = findViewById(R.id.studentList)
        studentsAdapter = StudentsAdapter(studentsList, applicationContext)
        studentsListRecyclerView.adapter = studentsAdapter
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