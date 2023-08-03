package com.example.rickAndMorty.test.common

//sealed class Result<out T>{
sealed class Result<T>(message:String?=null, data:T?=null){
    class Loading<T> : Result<T>()
    class Success<T>(val data: T?) : Result<T>(data= data)
    class Error<T>(val message: String) : Result<T>(message= message)
}
