package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.local.entities.User
import com.example.footballandroidapp.data.models.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<Result<User>>()
    val loginResult: LiveData<Result<User>> = _loginResult

    private val _registerResult = MutableLiveData<Result<User>>()
    val registerResult: LiveData<Result<User>> = _registerResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = authRepository.login(username, password)
            _loginResult.postValue(result)
        }
    }

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            val result = authRepository.register(username, email, password)
            _registerResult.postValue(result)
        }
    }
}