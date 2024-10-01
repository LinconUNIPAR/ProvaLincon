package com.example.provalincon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val transacoes = mutableListOf<String>()
    private lateinit var cartaocredito: cartaocredito

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCartaoCredito = findViewById<Button>(R.id.cartaocredito)
        val etCartaoDebito= findViewById<Button>(R.id.cartaodebito)
        val tvDataAtual = findViewById<TextView>(R.id.tvDataAtual)
        val recyclerViewAlunos = findViewById<RecyclerView>(R.id.recyclerViewTaffe)

        recyclerViewAlunos.layoutManager = LinearLayoutManager(this)
        cartaocredito = cartaocredito(transacoes)
        recyclerViewAlunos.adapter = cartaocredito

        val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        tvDataAtual.text = "Data Atual: $dataAtual"


    private fun atualizarQuantidade(tvQuantidadeAlunos: TextView) {
        tvQuantidadeAlunos.text = "Transações Feitas:" ${transacoes.size}"
    }
}