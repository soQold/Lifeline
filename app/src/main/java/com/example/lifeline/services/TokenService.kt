package com.example.lifeline.services

import android.content.SharedPreferences
import timber.log.Timber

class TokenService(private val sharedPref: SharedPreferences) {
    private val authTokenKey = "AUTH"
    private val refreshTokenKey = "REFRESH"

    fun getAuthToken(): String? {
        return sharedPref.getString(authTokenKey, null)
    }

    fun setAuthToken(token: String) {
        Timber.i("Setting new auth token: $token")
        sharedPref.edit().putString(authTokenKey, token).apply()
    }

    fun getRefreshToken(): String? {
        return sharedPref.getString(refreshTokenKey, null)
    }

    fun setRefreshToken(token: String) {
        Timber.i("Setting new refresh token: $token")
        sharedPref.edit().putString(refreshTokenKey, token).apply()
    }
}