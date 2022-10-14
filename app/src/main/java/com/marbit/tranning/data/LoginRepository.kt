package com.marbit.tranning.data

import java.net.HttpURLConnection
import java.net.URL

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class LoginRepository{

    private val loginUrl = "https://www.nicequest.com/kyld/3/mobile/auth/login"

    fun makeLoginRequest(
        jsonBody: String
    ): Result<LoginResponse> {
        val url = URL(loginUrl)
        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true
            outputStream.write(jsonBody.toByteArray())
            //return Result.Success(responseParser.parse(inputStream))
            return Result.Success(LoginResponse("",""))
        }
        return Result.Error(Exception("Cannot open HttpURLConnection"))
    }
}