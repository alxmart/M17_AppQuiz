package com.luizafmartinez.m17_appquiz

class DadosPerguntas {

    companion object {

        fun retornarListaPerguntas() : List<Pergunta> {

            val pergunta1 = Pergunta(
                "Qual a duração do primeiro vídeo do YouTube?",
                "30 segundos",
                "1 minuto",
                "3 minutos",
                1
            )

            val pergunta2 = Pergunta(
                "Qual o nome da estrela do nosso sistema Solar ?",
                "Cometa",
                "Sol",
                "Marte",
                2
            )

            val pergunta3 = Pergunta(
                "Qual o sisitem operacional usado no iPhone ? ",
                "Android",
                "Linux",
                "iOS",
                3
            )

            return listOf(
                pergunta1, pergunta2, pergunta3
            )

        }

    }


}