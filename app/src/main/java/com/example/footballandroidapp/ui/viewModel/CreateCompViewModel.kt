package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.models.comps.ICompsRepository
import com.example.footballandroidapp.data.remote.comps.CompCreate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateCompViewModel @Inject constructor(
    private val compRepo: ICompsRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<CreateTeamUiState>(CreateTeamUiState.Loading)
    val uiState: StateFlow<CreateTeamUiState>
        get() = _uiState.asStateFlow()

    fun CreateComp(comp: CompCreate){
        viewModelScope.launch {
            compRepo.createComp(comp)
        }
    }
}

sealed class CreateCompUiState(){
    data object Loading: CreateTeamUiState()
    class Success(val comp: List<Competition>): CreateTeamUiState()
    class Error(val message: String): CreateTeamUiState()

}