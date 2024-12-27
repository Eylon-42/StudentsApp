package com.efai.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.efai.studentsapp.model.Student

class AddStudent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        setUpListeners()
    }

    private fun setUpListeners() {
        val saveButton: Button = findViewById(R.id.addSave)
        val cancelButton: Button = findViewById(R.id.addCancel)

        saveButton.setOnClickListener {
            addStudent()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun addStudent() {
        val name: TextView = findViewById(R.id.addName)
        val id: TextView = findViewById(R.id.addId)
        val phone: TextView = findViewById(R.id.addPhone)
        val address: TextView = findViewById(R.id.addAddress)
        val checked: CheckBox = findViewById(R.id.addChecked)

        val position = MainActivity.studentsList.size
        MainActivity.studentsList.add(
            position,
            Student(
                name.text.toString(),
                id.text.toString(),
                phone.text.toString(),
                address.text.toString(),
                checked.isChecked
            )
        )
        finish()
    }
}