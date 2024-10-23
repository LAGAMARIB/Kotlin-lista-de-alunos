package com.livrokotlin.listadealunos.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.livrokotlin.listadealunos.data.AlunoDatabase

class AlunosViewModelFactory(
    private val applicationContext: Context
): ViewModelProvider.Factory {

    private fun createDatabase() : AlunoDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AlunoDatabase::class.java, "alunos.db"
        ).build()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlunosViewModel( createDatabase() ) as T
    }
}