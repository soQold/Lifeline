package com.example.lifeline.domain.common

sealed class LifelineResult<out R> {
    data class Success<T>(val data: T, val token: String? = null) : LifelineResult<T>()
    data class Error(val exception: Exception) : LifelineResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}