package com.efai.studentsapp.model

import android.graphics.Bitmap

data class Student(
    var name: String,
    var id: String,
    var phone: String,
    var address: String,
    var checked: Boolean,
    var pic: Bitmap? = null
) {
    fun setStudent(name: String, id: String, phone: String, address: String, checked: Boolean) {
        this.name = name
        this.id = id
        this.phone = phone
        this.address = address
        this.checked = checked
    }
}