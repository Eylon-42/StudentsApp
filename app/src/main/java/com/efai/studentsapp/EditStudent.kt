package com.efai.studentsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditStudent : AppCompatActivity() {

    private var position: Int = 0
    private lateinit var nameTextView: TextView
    private lateinit var idTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var checkedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)
        supportActionBar?.title = "Edit Students"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nameTextView = findViewById(R.id.editName)
        idTextView = findViewById(R.id.editId)
        phoneTextView = findViewById(R.id.editPhone)
        addressTextView = findViewById(R.id.editAddress)
        checkedCheckBox = findViewById(R.id.editChecked)

        intent?.let {
            nameTextView.text = it.getStringExtra("name")
            idTextView.text = it.getStringExtra("id")
            phoneTextView.text = it.getStringExtra("phone")
            addressTextView.text = it.getStringExtra("address")
            checkedCheckBox.isChecked = it.getBooleanExtra("checked", false)
            position = it.getIntExtra("position", 0)
        }

        setUpListeners()
    }

    private fun setUpListeners() {
        val saveButton: Button = findViewById(R.id.editSave)
        val cancelButton: Button = findViewById(R.id.editCancel)
        val deleteButton: Button = findViewById(R.id.editDelete)

        saveButton.setOnClickListener {
            editStudent()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        cancelButton.setOnClickListener {
            finish()
        }

        deleteButton.setOnClickListener {
            MainActivity.studentsList.removeAt(position)
            MainActivity.studentsAdapter.notifyItemRemoved(position)
            // Return to MainActivity and clear back stack
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }

    private fun editStudent() {
        MainActivity.studentsList[position].apply {
            setStudent(
                nameTextView.text.toString(),
                idTextView.text.toString(),
                phoneTextView.text.toString(),
                addressTextView.text.toString(),
                checkedCheckBox.isChecked
            )
        }
        MainActivity.studentsAdapter.notifyItemChanged(position)
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