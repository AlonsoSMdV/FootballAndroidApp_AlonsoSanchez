package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.models.teams.ITeamRepository
import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.data.remote.teams.TeamCreate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTeamViewModel @Inject constructor(
    private val teamRepo: ITeamRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<CreateTeamUiState>(CreateTeamUiState.Loading)
    val uiState: StateFlow<CreateTeamUiState>
        get() = _uiState.asStateFlow()

    fun CreateTeam(team: TeamCreate){
        viewModelScope.launch {
            teamRepo.createTeam(team)
        }
    }
}

sealed class CreateTeamUiState(){
    data object Loading: CreateTeamUiState()
    class Success(val team: List<Team>): CreateTeamUiState()
    class Error(val message: String): CreateTeamUiState()

}