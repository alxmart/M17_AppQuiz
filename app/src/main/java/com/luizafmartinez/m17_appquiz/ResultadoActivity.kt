package com.luizafmartinez.m17_appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textResultadoFinal: TextView
    private lateinit var btnEncerrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        inicializarComponentes()
    }

    private fun inicializarComponentes() {

        textResultadoFinal = findViewById(R.id.text_resultado_final)
        btnEncerrar = findViewById(R.id.btn_encerrar)

        val extra = intent.extras

        if ( extra != null ) {

            val totalRespostasCorretas = extra.getInt("totalRespostasCorretas")
            val totalPerguntas = extra.getInt("totalPerguntas")

            textResultadoFinal.text = "Acertou $totalRespostasCorretas de $totalPerguntas."

            btnEncerrar.setOnClickListener {

                val intent = Intent(
                    this,
                    MainActivity::class.java
                )

                startActivity(intent)

                finish()
            }
        }
    }
}