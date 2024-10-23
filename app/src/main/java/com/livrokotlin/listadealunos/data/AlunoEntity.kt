package com.livrokotlin.listadealunos.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.livrokotlin.listadealunos.models.AlunoModel

@Entity
class AlunoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nome: String
)

fun AlunoEntity.toModel(onRemove: (AlunoModel) -> Unit): AlunoModel {
    return AlunoModel(
        id = this.id,
        nome = this.nome,
        onRemove = onRemove
    )
}