package com.example.simulador.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simulador.R
import com.example.simulador.data.MatchesApi
import com.example.simulador.databinding.ActivityMainBinding
import com.example.simulador.domain.Match
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var matchesApi: MatchesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setuHttpClient()
        setupMatchesList()
        setupMatchesRefresh()
        setupFloatingActionButton()

    }

    private fun setuHttpClient() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://robsondmf1234.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        matchesApi = retrofit.create(MatchesApi::class.java)

    }

    private fun setupFloatingActionButton() {
        //TODO Criar evento de click de simulação de partidas.
    }

    private fun setupMatchesRefresh() {
        //TODO atualizar as partidas na ação de swipe
    }

    private fun setupMatchesList() {
        matchesApi.getMatches().enqueue(object : Callback<List<Match>> {

            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                if (response.isSuccessful()) {
                    if (!response.body().isNullOrEmpty()) {
                        val listMatches: List<Match>? = response.body()
                        Log.i("Simulator", "Deu tudo certo!! -Tamanho: ${listMatches?.size}")
                    }

                } else {
                    showErrorMessage()
                }
            }


            override fun onFailure(call: Call<List<Match>>, t: Throwable?) {
                showErrorMessage()
            }

        })
    }

    private fun showErrorMessage() {
        Toast.makeText(this, R.string.error_api, Toast.LENGTH_SHORT).show()
    }
}