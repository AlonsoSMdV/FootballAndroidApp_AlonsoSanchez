package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.models.players.IPlayerRepository
import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.data.remote.players.PlayerCreate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePlayerViewModel @Inject constructor(
    private val playerRepo: IPlayerRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<CreatePlayerUiState>(CreatePlayerUiState.Loading)
    val uiState: StateFlow<CreatePlayerUiState>
        get() = _uiState.asStateFlow()

    fun CreatePlayer(player: PlayerCreate){
        viewModelScope.launch {
            playerRepo.createPlayer(player)
        }
    }
}

sealed class CreatePlayerUiState(){
    data object Loading: CreatePlayerUiState()
    class Success(val player: List<Player>): CreatePlayerUiState()
    class Error(val message: String): CreatePlayerUiState()

}