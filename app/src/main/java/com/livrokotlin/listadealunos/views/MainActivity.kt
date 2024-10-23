package com.livrokotlin.listadealunos.views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.livrokotlin.listadealunos.R
import com.livrokotlin.listadealunos.adapters.AlunosAdapter
import com.livrokotlin.listadealunos.viewModels.AlunosViewModel
import com.livrokotlin.listadealunos.viewModels.AlunosViewModelFactory

class MainActivity : AppCompatActivity() {

    val alunosViewModel: AlunosViewModel by viewModels {
        AlunosViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonInsert = findViewById<Button>(R.id.buttonInsert)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val alunosAdapter = AlunosAdapter()
        recyclerView.adapter = alunosAdapter

        buttonInsert.setOnClickListener {
            if (editTextName.text.isEmpty()) {
                editTextName.error = "Preencha do nome do aluno"
                return@setOnClickListener
            }
            alunosViewModel.addAluno(editTextName.text.toString())
            editTextName.text.clear()
        }

        alunosViewModel.alunosLiveData.observe(this ) { alunos ->
            alunosAdapter.updateAlunosList(alunos)
        }
    }
}