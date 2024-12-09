package com.example.footballandroidapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.data.models.comps.ICompsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val compRepo: ICompsRepository
): ViewModel(){
    private val _uiState = MutableStateFlow<CompListUiState>(CompListUiState.Loading)
    val  uiState: StateFlow<CompListUiState>
        get() = _uiState.asStateFlow()

    fun deleteComp(comId: Int){
        viewModelScope.launch {
            compRepo.deleteComp(comId)
            withContext(Dispatchers.IO){
                compRepo.readAll()
            }
        }
    }
    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                compRepo.setStream.collect{
                    compList ->
                    if (compList.isEmpty()){
                        _uiState.value = CompListUiState.Loading
                    }else{
                        _uiState.value = CompListUiState.Success(compList)
                    }
                }
            }
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                compRepo.readAll()
            }
        }
    }

}

sealed class CompListUiState(){
    data object Loading: CompListUiState()
    class Success(val compList: List<Competition>): CompListUiState()
    class Error(val message: String): CompListUiState()
}