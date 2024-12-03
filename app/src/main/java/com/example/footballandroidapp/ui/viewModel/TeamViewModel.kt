package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.models.teams.ITeamRepository
import com.example.footballandroidapp.data.models.teams.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamRepo: ITeamRepository
): ViewModel(){
    private val _uiState = MutableStateFlow<TeamListUiState>(TeamListUiState.Loading)
    val  uiState: StateFlow<TeamListUiState>
        get() = _uiState.asStateFlow()


    init {


        viewModelScope.launch {
            withContext(Dispatchers.IO){
                teamRepo.setStream.collect{
                        teamList ->
                    if (teamList.isEmpty()){
                        _uiState.value = TeamListUiState.Loading
                    }else{
                        _uiState.value = TeamListUiState.Success(teamList)
                    }
                }
            }
        }
        /*viewModelScope.launch {
            withContext(Dispatchers.IO){
                teamRepo.readAll()
            }
        }*/

    }

    fun observeTeamsByLeague(leagueId:Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                teamRepo.readTeamsByLeague(leagueId)
            }
        }
    }

}

sealed class TeamListUiState(){
    data object Loading: TeamListUiState()
    class Success(val teamList: List<Team>): TeamListUiState()
    class Error(val message: String): TeamListUiState()
}