package com.livrokotlin.listadealunos.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.livrokotlin.listadealunos.data.AlunoDatabase
import com.livrokotlin.listadealunos.data.AlunoEntity
import com.livrokotlin.listadealunos.data.toModel
import com.livrokotlin.listadealunos.models.AlunoModel
import com.livrokotlin.listadealunos.models.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlunosViewModel(private val database: AlunoDatabase): ViewModel() {

    val alunosLiveData = MutableLiveData<List<AlunoModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAll()
        }
    }

    private suspend fun fetchAll() {
        var result = database.alunoDao().getAll().map {
            it.toModel(onRemove = ::removeAluno)
        }
        alunosLiveData.postValue(result)
    }

    fun addAluno(nome: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = AlunoEntity(id = 0, nome = nome)
            database.alunoDao().insert(entity)
            fetchAll()
        }
    }

    fun removeAluno(alunoModel: AlunoModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = alunoModel.toEntity()
            database.alunoDao().delete(entity)
            fetchAll()
        }
    }
}