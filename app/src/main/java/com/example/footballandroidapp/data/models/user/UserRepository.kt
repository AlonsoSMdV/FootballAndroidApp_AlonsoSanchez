package com.example.footballandroidapp.data.models.user


import com.example.footballandroidapp.data.local.database.UserDao
import com.example.footballandroidapp.data.local.entities.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun getUser(): User? = userDao.getUser()
    suspend fun clearUsers() = userDao.clear()
}