package com.example.simulador.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simulador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMatchesList()
        setupMatchesRefresh()
        setupFloatingActionButton()

    }

    private fun setupFloatingActionButton() {
        //TODO Criar evento de click de simulação de partidas.
    }

    private fun setupMatchesRefresh() {
        //TODO atualizar as partidas na ação de swipe
    }

    private fun setupMatchesList() {
        //TODO listar as partidas, consumindo a api do Github
    }
}