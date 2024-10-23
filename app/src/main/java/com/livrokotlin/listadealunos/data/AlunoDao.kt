package com.livrokotlin.listadealunos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlunoDao {
    @Insert
    fun insert(aluno: AlunoEntity): Long

    @Delete
    fun delete(aluno: AlunoEntity): Int

    @Query("select * from alunoEntity")
    suspend fun getAll(): List<AlunoEntity>
}