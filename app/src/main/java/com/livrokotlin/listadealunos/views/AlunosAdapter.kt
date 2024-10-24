package com.livrokotlin.listadealunos.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.livrokotlin.listadealunos.R
import com.livrokotlin.listadealunos.commons.CommonFunctions
import com.livrokotlin.listadealunos.models.AlunoModel

class AlunosAdapter(private val context: Context): RecyclerView.Adapter<AlunosAdapter.AlunoViewHolder>() {

    private var alunos = listOf<AlunoModel>()

    fun updateAlunosList(listAlunos: List<AlunoModel>){
        alunos = listAlunos
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aluno_layout, parent, false)
        return AlunoViewHolder(view)
    }

    override fun getItemCount(): Int = alunos.size

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.bind(aluno)
    }

    class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewAlunoNome)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        fun bind(aluno: AlunoModel) {
            textView.text = aluno.nome
            button.setOnClickListener {
                CommonFunctions.confirm(itemView.context) {
                    aluno.onRemove(aluno)
                }
            }
        }
    }

}