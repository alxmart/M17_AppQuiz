package com.luizafmartinez.m17_appquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.os.bundleOf

class PerguntasActivity : AppCompatActivity() {

    //Componentes
    private lateinit var textExibicaoNome: TextView
    private lateinit var textExibicaoResumo: TextView
    private lateinit var textTitulo: TextView
    private lateinit var radioResposta1: RadioButton
    private lateinit var radioResposta2: RadioButton
    private lateinit var radioResposta3: RadioButton
    private lateinit var btnConfirmar: Button

    private lateinit var listaPerguntas: List<Pergunta>
    private lateinit var perguntaAtual: Pergunta
    private var indicePerguntaAtual = 0

    // Totalizadores
    private var totalPerguntas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)
        inicializarComponentesInterface()

        // pergunta1, pergunta2, pergunta3
        listaPerguntas = DadosPerguntas.retornarListaPerguntas()
        exibirDadosPerguntaAtual()

        btnConfirmar.setOnClickListener {

            indicePerguntaAtual++

            if ( indicePerguntaAtual < totalPerguntas) {
                exibirDadosPerguntaAtual()
            }  else {
                // Questionário finalizado
            }

        }

    }

    private fun exibirDadosPerguntaAtual() {

        perguntaAtual = listaPerguntas[ indicePerguntaAtual ]

        //Exibir os dados
        totalPerguntas = listaPerguntas.size
        val textoResumo = "${ indicePerguntaAtual + 1 } pergunta de $totalPerguntas"

        textExibicaoResumo.text = textoResumo
        textTitulo.text = perguntaAtual.titulo
        radioResposta1.text = perguntaAtual.resposta1
        radioResposta2.text = perguntaAtual.resposta2
        radioResposta3.text = perguntaAtual.resposta3


    }

    override fun onStart() {
        super.onStart()
    }

    private fun inicializarComponentesInterface() {

        textExibicaoNome   = findViewById(R.id.text_exibicao_nome)
        textExibicaoResumo = findViewById(R.id.text_exibicao_resumo)
        textTitulo         = findViewById(R.id.text_titulo)
        radioResposta1     = findViewById(R.id.radio_resposta1)
        radioResposta2     = findViewById(R.id.radio_resposta2)
        radioResposta3     = findViewById(R.id.radio_resposta3)
        btnConfirmar       = findViewById(R.id.btn_confirmar)

        val bundle = intent.extras

        val nome = bundle?.getString("nome")

        if ( nome != null) {
            textExibicaoNome.text = "Olá, $nome"
        }

    }
}













