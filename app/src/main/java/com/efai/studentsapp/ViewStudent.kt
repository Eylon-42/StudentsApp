package com.efai.studentsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewStudent : AppCompatActivity() {

    private var name: String? = null
    private var id: String? = null
    private var phone: String? = null
    private var address: String? = null
    private var checked: Boolean = false
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_view_student)
        supportActionBar?.title = "Students Details" // Set the title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpListeners()

        intent?.let {
            name = it.getStringExtra("name")
            id = it.getStringExtra("id")
            phone = it.getStringExtra("phone")
            address = it.getStringExtra("address")
            checked = it.getBooleanExtra("checked", false)
            position = it.getIntExtra("position", 0)
        }

        val studentName: TextView = findViewById(R.id.currentStudentname)
        val studentPhone: TextView = findViewById(R.id.currentStudentPhone)
        val studentAddress: TextView = findViewById(R.id.currentStudentAddress)
        val studentId: TextView = findViewById(R.id.currentStudentid)
        val studentChecked: CheckBox = findViewById(R.id.viewChecked)

        studentName.text = name
        studentId.text = id
        studentPhone.text = phone
        studentAddress.text = address
        studentChecked.isChecked = checked
    }
    private fun setUpListeners() {
        val editButton: Button = findViewById(R.id.viewEdit)
        editButton.setOnClickListener {
            val intent = Intent(applicationContext, EditStudent::class.java).apply {
                putExtra("name", name)
                putExtra("id", id)
                putExtra("phone", phone)
                putExtra("address", address)
                putExtra("checked", checked)
                putExtra("position", position)
            }
            startActivity(intent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle navigation back to MainActivity
                finish() // Close ViewStudent and return to MainActivity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}