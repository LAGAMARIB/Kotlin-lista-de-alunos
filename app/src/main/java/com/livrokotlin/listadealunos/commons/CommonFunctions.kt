package com.livrokotlin.listadealunos.commons

import android.content.Context
import androidx.appcompat.app.AlertDialog

object CommonFunctions {
    fun confirm(context: Context, onConfirm: () -> Unit) {
       val builder = AlertDialog.Builder(context)
       builder.setTitle("Confirmação")
       builder.setMessage("Confirma excluir o registro?")

       builder.setPositiveButton("Sim") { dialog, _ ->
           onConfirm()
           dialog.dismiss()
       }

       builder.setNegativeButton("Não") { dialog, _ -> dialog.dismiss() }

       builder.show()
    }
}