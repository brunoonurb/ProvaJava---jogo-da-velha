package br.fapi.poo.testandocombuffer;

import br.fapi.poo.Util.Leitura;

import java.io.File;

public class AddAtributosFile {
    Leitura ler = new Leitura();

    public void criarArquivo(Jogador jogador){
        jogador.nome = ler.lerString("Nome do jogador");
        jogador.dificuldade = ler.lerString("Qual dificuldade");

        jogador.fileJogador = new File(jogador.nome + jogador.dificuldade".txt");
    }


}
