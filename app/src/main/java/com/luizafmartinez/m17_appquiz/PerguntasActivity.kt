package com.luizafmartinez.m17_appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf

class PerguntasActivity : AppCompatActivity() {

    //Componentes
    private lateinit var textExibicaoNome: TextView
    private lateinit var textExibicaoResumo: TextView
    private lateinit var textTitulo: TextView
    private lateinit var radioResposta1: RadioButton
    private lateinit var radioResposta2: RadioButton
    private lateinit var radioResposta3: RadioButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnConfirmar: Button

    private lateinit var listaPerguntas: List<Pergunta>
    private lateinit var perguntaAtual: Pergunta
    private var indicePerguntaAtual = 0

    // Totalizadores
    private var totalPerguntas = 0
    private var totalRespostasCorretas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)
        inicializarComponentesInterface()

        // pergunta1, pergunta2, pergunta3
        listaPerguntas = DadosPerguntas.retornarListaPerguntas()
        exibirDadosPerguntaAtual()

        btnConfirmar.setOnClickListener {

            if (validarResposta()) {

                exibirResultadoResposta()
                indicePerguntaAtual++
                // 0,1,2 -> 3
                if (indicePerguntaAtual < totalPerguntas) {
                    exibirDadosPerguntaAtual()
                } else {// Questionário finalizado
                   val intent = Intent(this,
                       ResultadoActivity::class.java
                   )
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this,
                    "Preencha ao menos uma resposta",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun exibirResultadoResposta() {

        val perguntaCerta = perguntaAtual.respostaCerta

        val respostaSelecionada = when {
            radioResposta1.isChecked -> 1
            radioResposta2.isChecked -> 2
            radioResposta3.isChecked -> 3
            else -> 0
        }
        if ( perguntaCerta == respostaSelecionada ) {
            totalRespostasCorretas++
            Toast.makeText(
                this,
                "Resposta Correta",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                this,
                "Resposta errada",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun validarResposta(): Boolean {

        /*  val idRadioButtonSelecionado = radioGroup.checkedRadioButtonId

          return when ( idRadioButtonSelecionado ) {
              R.id.radio_resposta1  ->
              R.id.radio_resposta2  ->
              R.id.radio_resposta3  ->
                  else -> true
          }*/

        if (radioResposta1.isChecked ||
            radioResposta2.isChecked ||
            radioResposta3.isChecked )
        {
            return true
        } else {
            return false
        }
    }


    private fun exibirDadosPerguntaAtual() {

        perguntaAtual = listaPerguntas[indicePerguntaAtual]

        //Exibir os dados
        totalPerguntas = listaPerguntas.size
        val textoResumo = "${indicePerguntaAtual + 1} pergunta de $totalPerguntas"

        textExibicaoResumo.text = textoResumo
        textTitulo.text = perguntaAtual.titulo
        radioResposta1.text = perguntaAtual.resposta1
        radioResposta2.text = perguntaAtual.resposta2
        radioResposta3.text = perguntaAtual.resposta3

        radioGroup.clearCheck()

    }

    override fun onStart() {
        super.onStart()
    }

    private fun inicializarComponentesInterface() {

        textExibicaoNome = findViewById(R.id.text_exibicao_nome)
        textExibicaoResumo = findViewById(R.id.text_exibicao_resumo)
        textTitulo = findViewById(R.id.text_titulo)
        radioResposta1 = findViewById(R.id.radio_resposta1)
        radioResposta2 = findViewById(R.id.radio_resposta2)
        radioResposta3 = findViewById(R.id.radio_resposta3)
        radioGroup = findViewById(R.id.radio_group)
        btnConfirmar = findViewById(R.id.btn_confirmar)

        val bundle = intent.extras

        val nome = bundle?.getString("nome")

        if (nome != null) {
            textExibicaoNome.text = "Olá, $nome"
        }
    }
}














