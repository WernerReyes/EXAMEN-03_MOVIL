package com.reyes.werner.laboratoriocalificado03

data class TeacherResponse(
    val name: String,
    val last_name: String,
    val phone_number: String,
    val email: String,
    val image_url: String
) {
    fun getIdTeacherFromEmail(email: String): String = email.split("@").toTypedArray()[0]


    fun getTeacherImage(email: String): String {
        return "https://raw.githubusercontent.com/victorskatepro/ContactList/master/app/src/main/res/drawable/${getIdTeacherFromEmail(email)}.jpeg"
    }
}

