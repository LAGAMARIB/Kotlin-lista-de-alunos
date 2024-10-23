package com.livrokotlin.listadealunos.models

import com.livrokotlin.listadealunos.data.AlunoEntity

data class AlunoModel (
    val id: Long,
    val nome: String,
    var onRemove: (AlunoModel) -> Unit
)

fun AlunoModel.toEntity(): AlunoEntity {
    return AlunoEntity(
        id = this.id,
        nome = this.nome
    )
}