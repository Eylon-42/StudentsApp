package com.efai.studentsapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.efai.studentsapp.MainActivity
import com.efai.studentsapp.R
import com.efai.studentsapp.ViewStudent
import com.efai.studentsapp.model.Student

class StudentsAdapter(
    private val studentsList: ArrayList<Student>,
    private val context: Context
) : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val studentView = inflater.inflate(R.layout.student_item, parent, false)
        return ViewHolder(studentView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentsList[position]

        holder.studentName.text = student.name
        holder.studentId.text = student.id
        holder.studentChecked.isChecked = student.checked
        holder.studentPic.setImageResource(R.drawable.student)

        holder.studentChecked.setOnCheckedChangeListener { _, isChecked ->
            MainActivity.studentsList[position].checked = isChecked
            studentsList[position].checked = isChecked
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ViewStudent::class.java).apply {
                putExtra("name", holder.studentName.text.toString())
                putExtra("id", holder.studentId.text.toString())
                putExtra("phone", student.phone)
                putExtra("address", student.address)
                putExtra("checked", holder.studentChecked.isChecked)
                putExtra("position", position)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = studentsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentPic: ImageView = itemView.findViewById(R.id.studentPic)
        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val studentId: TextView = itemView.findViewById(R.id.studentId)
        val studentChecked: CheckBox = itemView.findViewById(R.id.studentChecked)
    }
}