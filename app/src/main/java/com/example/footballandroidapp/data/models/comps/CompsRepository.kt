package com.example.footballandroidapp.data.models.comps

import com.example.footballandroidapp.data.local.iLocalDataSource.ICompsLocalDataSource
import com.example.footballandroidapp.data.remote.comps.CompCreate
import com.example.footballandroidapp.data.remote.comps.ICompRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CompsRepository @Inject constructor(
    private val remoteData: ICompRemoteDataSource,
    private val localData: ICompsLocalDataSource
): ICompsRepository {

    private val _state = MutableStateFlow<List<Competition>>(listOf())
    override val setStream: StateFlow<List<Competition>>
        get() = _state.asStateFlow()

    override suspend fun readAll(): List<Competition> {
        val res = remoteData.readAll()
        val comps = _state.value.toMutableList()
        if (res.isSuccessful){
            val compList = res.body()?.data ?: emptyList()
            _state.value = compList.toExternal()
        }
        else _state.value = comps
        return comps
    }

    override suspend fun readOne(id: Int): Competition {
        val res = remoteData.readOne(id)
        return if (res.isSuccessful)res.body()!!
        else Competition("0","")
    }

    override suspend fun createComp(comp: CompCreate) {
        remoteData.createComp(comp)
    }

    override suspend fun deleteComp(id: Int) {
        remoteData.deleteComp(id)
    }

    override fun observeAll(): Flow<List<Competition>> {
        refreshLocal()
        return localData.observeAll()
    }

    private fun refreshLocal(){
        runBlocking {
            val compRemote = remoteData.readAll()
        }
    }
}