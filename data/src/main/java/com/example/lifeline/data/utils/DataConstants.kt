package com.example.lifeline.data.utils

class DataConstants {
    companion object{
        private const val baseUrl = "http://77.222.52.53:8080/api/"
        const val baseAuthUrl = "${baseUrl}auth/"
        const val baseUsersUrl = "${baseUrl}users/"
        const val baseConstantsUrl = "${baseUrl}constant/"
        const val emptyString = ""

        const val male = "male"
        const val female = "female"
    }
}