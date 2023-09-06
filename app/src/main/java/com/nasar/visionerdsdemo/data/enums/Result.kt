package com.nasar.visionerdsdemo.data.enums

import androidx.lifecycle.MutableLiveData

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()

    data class Loading(val message: String):Result<Nothing>()
}

class ResultLiveData<T> : MutableLiveData<Result<T>>() {
    fun setLoading() {
        value = Result.Loading("Loading")
    }
}
