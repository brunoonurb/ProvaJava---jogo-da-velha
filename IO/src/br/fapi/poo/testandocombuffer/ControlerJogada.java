package br.fapi.poo.testandocombuffer;

import br.fapi.poo.Util.Leitura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlerJogada {
    Leitura ler = new Leitura();

public void controlador(){
    AlterarFile alterarFile = new AlterarFile();
    Jogo jogo = new Jogo();
    /*aqiu so para testar*/
    jogo.nome = ler.lerString("Nome do jogador");
    jogo.dificuldade = ler.lerString("Qual dificuldade");


    File meuFile = alterarFile.criarArquivo(jogo.nome,jogo.dificuldade);
    jogo.fileJogador = meuFile;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    jogo.dataHoraInicio = dateFormat.format(date);;
    jogo.dataHorafim = dateFormat.format(date);;
    System.out.println(date);


    if (jogo.fileJogador.exists()) {
        alterarFile.visualizar(jogo);

        //pegar arquivo mandar jogado

        System.out.println("voce gostaria de retorna a jogo anterior |1| sim |2|nao");
        int escolha = (new Leitura()).lerInt();
        if (escolha == 2) {
            System.out.println("delete");


            System.out.println(jogo.fileJogador.delete());
        }

    }
    if (!jogo.fileJogador.exists()) {
        System.out.println("se nao existe");



        alterarFile.inserirFile(jogo);
        alterarFile.visualizar(jogo);


    }

}


}

