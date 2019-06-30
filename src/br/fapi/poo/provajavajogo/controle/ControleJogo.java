package br.fapi.poo.provajavajogo.controle;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import br.fapi.poo.provajavajogo.modelo.Jogo;
import br.fapi.poo.provajavajogo.util.Leitura;
import br.fapi.poo.provajavajogo.util.Menu;

public class ControleJogo {
	private static ControleJogo instancia;

	private ControleJogo() {
	}

	public static synchronized ControleJogo getInstancia() {
		if (instancia == null) {
			instancia = new ControleJogo();
		}
		return instancia;
	}

	public void receberNomeJogador() {
		Jogo.getInstancia().setNomeJogador(Leitura.getInstancia().lerString("Digite o nome do jogador: "));
		Menu.getInstancia().menuNiveis();
	}

	public void comecarJogo() {
		// char[] palavraQuebrada = Jogo.getInstancia().getPalavra().toCharArray();
		int cont;
		int cont2;
		Character palpite = null;
		System.out.println("A palavra a ser advinhada �: " + Jogo.getInstancia().getPalavra());
		do {
			cont2 = 0;
			// char hifen='-',espaco=' ';
			System.out.println(
					"======================================================================================================");
			System.out.println("\n|JOGADOR|     : " + Jogo.getInstancia().getNomeJogador());
			System.out.println("|DIFICULDADE| : " + Jogo.getInstancia().getDificuldade());
			System.out.println("|TENTATIVAS | : " + Jogo.getInstancia().getTentativasUsadas());
			System.out.println("|N� CHANCES | : " + Jogo.getInstancia().getTentativasRestantes());
			System.out.println("|LETRAS DIG|  : " + Arrays.toString(Jogo.getInstancia().getLetrasPalpites().toArray()));
			System.out.println("|LETRAS ERR|  : " + Arrays.toString(Jogo.getInstancia().getLetrasErradas().toArray()));
			System.out.println("\nDIGITE 0 PARA PAUSAR E VOLTAR PARA O MENU PRINCIPAL");
			System.out.print("\nPalavra a ser adivinhada: \t");

			for (int i = 0; i < Jogo.getInstancia().getPalavra().length(); i++) {
				cont = 0;
				for (int j = 0; j < Jogo.getInstancia().getLetrasPalpites().size(); j++) {
					if (Character.toUpperCase(Jogo.getInstancia().getPalavra().charAt(i)) == Jogo.getInstancia()
							.getLetrasPalpites().get(j)) {
						cont = 1;
					}
				}
				if ((Character.toUpperCase(Jogo.getInstancia().getPalavra().charAt(i)) == '-')
						|| (Character.toUpperCase(Jogo.getInstancia().getPalavra().charAt(i)) == ' ')) {
					cont = 1;
				}
				if (cont == 1) {
					cont2++;
					System.out.print(" " + Jogo.getInstancia().getPalavra().charAt(i) + "  ");
				} else {
					System.out.print(" *  ");
				}
			}

			System.out.print("\n\t\t\t\t");
			for (int i = 0; i < Jogo.getInstancia().getPalavra().length(); i++) {
				System.out.print("___ ");
			}
			System.out.println("\n\n");
			if (Jogo.getInstancia().getTentativasRestantes() == 0) {
				Jogo.getInstancia().setEstadoDoJogo("DERROTA");
				// BRUNO: Atualizar data fim para o JOGO
				System.out.println("Voce perdeu o jogo!");
				System.out.println("Pressione ENTER");
				Leitura.getInstancia().lerString();
				Leitura.getInstancia().lerString();
				// BRUNO: Atualizar o jogo para o arquivo
				Menu.getInstancia().menuPrincipal();
			}

			if (cont2 == Jogo.getInstancia().getPalavra().length()) {
				System.out.println("\nVoce ganhou o jogo!");
				System.out.println("Pressione ENTER");
				Leitura.getInstancia().lerString();
				Leitura.getInstancia().lerString();
				// BRUNO: Atualizar o jogo para o arquivo: data fim, vitoria,jogadas,etc
				(new AlterarFile()).criarArquivo();
			}

			do {
				cont = 0;
				palpite = Leitura.getInstancia().lerChar("Digite uma letra: ");
				palpite = Character.toUpperCase(palpite);
				// boolean verificacao = palpite.isLetter(0);
				for (int i = 0; i < Jogo.getInstancia().getLetrasPalpites().size(); i++) {
					if (palpite == Jogo.getInstancia().getLetrasPalpites().get(i)) {
						cont = 1;
						System.out.println("Esta letra ja foi informada");
					}
				}
			} while (cont == 1);
			cont = 0;
			for (int i = 0; i < Jogo.getInstancia().getPalavra().length(); i++) {
				if (palpite == Character.toUpperCase(Jogo.getInstancia().getPalavra().charAt(i))) {
					cont = 1;
				}
			}
			if (cont != 1) {
				Jogo.getInstancia().setTentativasUsadas(1);
				Jogo.getInstancia().getLetrasErradas().add(palpite);
			}
			Jogo.getInstancia().getLetrasPalpites().add(palpite);
			(new AlterarFile()).criarArquivo();
		} while (palpite != 0);
		// THIAGO: fazer try catch
		Jogo.getInstancia().setEstadoDoJogo("PAUSADO");
		Jogo.getInstancia().setInterrupcoes(1);
		// BRUNO: mandar a data fim para o JOGO ou somente quando der vitoria ou
		// derrota?
		// BRUNO: Atualizar o jogo para o arquivo
		(new AlterarFile()).criarArquivo();
		Menu.getInstancia().menuPrincipal();

	}

	public void inserirPalavra() {
		String palavra = Leitura.getInstancia().lerString("Digite a palavra a ser adivinhada: ");
		Jogo.getInstancia().setPalavra(palavra);
		// BRUNO:Colocar ou nao aqui ja a palavra
		comecarJogo();
	}

	public void criarNovoJogo() {
		System.out.println("*criando novo jogo");
		// BRUNO: setar data e hora no jogo
		// BRUNO:Criar novo arquivo que tenha: nome jogador, nivel, data e hora de
		// inicio
		(new AlterarFile()).criarArquivo();
	}

	public void continuarAbandonarJogo() {
		String escolha;
		do {
			escolha = Leitura.getInstancia().lerString("Deseja continuar o jogo?(S/N)");
			escolha = escolha.toUpperCase();
		} while (!((escolha.equals("S")) || (escolha.equals("N"))));
		switch (escolha) {
		case "S":
			// BRUNO: Carrega arquivo e copiar para as variaveis
			// comecarJogo(); depois disso descomenta para testar
			(new AlterarFile()).coletarDados();
			break;
		case "N":
			Jogo.getInstancia().getMyFile().delete();
			criarNovoJogo();
			inserirPalavra();
			break;

		}
	}

}
