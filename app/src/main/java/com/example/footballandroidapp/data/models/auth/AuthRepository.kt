package com.example.footballandroidapp.data.models.auth

import com.example.footballandroidapp.data.local.database.UserDao
import com.example.footballandroidapp.data.local.entities.User
import com.example.footballandroidapp.data.remote.api.FootballApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: FootballApi,
    private val userDao: UserDao
) {
    suspend fun login(username: String, password: String): Result<User> {
        val response = api.login(mapOf("identifier" to username, "password" to password))
        return if (response.isSuccessful) {
            val user = response.body()?.user?.copy(token = response.body()?.jwt)
            user?.let {
                userDao.insert(it)
                Result.success(it)
            } ?: Result.failure(Exception("User not found"))
        } else {
            Result.failure(Exception(response.message()))
        }
    }

    suspend fun register(username: String, email: String, password: String): Result<User> {
        val response = api.register(mapOf("username" to username, "email" to email, "password" to password))
        return if (response.isSuccessful) {
            val user = response.body()?.user?.copy(token = response.body()?.jwt)
            user?.let {
                userDao.insert(it)
                Result.success(it)
            } ?: Result.failure(Exception("User not created"))
        } else {
            Result.failure(Exception(response.message()))
        }
    }
}