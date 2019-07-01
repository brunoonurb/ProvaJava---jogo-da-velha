package br.fapi.poo.provajavajogo.util;

import java.util.InputMismatchException;

import br.fapi.poo.provajavajogo.controle.AlterarFile;
import br.fapi.poo.provajavajogo.controle.ControleFile;
import br.fapi.poo.provajavajogo.controle.ControleGeral;
import br.fapi.poo.provajavajogo.controle.ControleJogo;
import br.fapi.poo.provajavajogo.modelo.Jogo;
import br.fapi.poo.provajavajogo.modelo.Nivel;
import br.fapi.poo.provajavajogo.modelo.NivelDificil;
import br.fapi.poo.provajavajogo.modelo.NivelFacil;
import br.fapi.poo.provajavajogo.modelo.NivelMedio;

public class Menu {
	private static Menu instancia;
	int escolha =0;
	private Menu() {
	}

	public static synchronized Menu getInstancia() {
		if (instancia == null) {
			instancia = new Menu();
		}
		return instancia;
	}

	public void menuRelatorio() {

		System.out.println("|1| - Gerar relatorio geral");
		System.out.println("|2| - Gerar relatorios de vitorias");
		System.out.println("|3| - Gerar relatorio de derrotas");
		System.out.println("|0| - Voltar ao menu principal");

		try {
			escolha = Leitura.getInstancia().lerInt();//codigo duplicado
		} catch (InputMismatchException e) {
			System.out.println("\nDigite somente numeros\n");
			Leitura.getInstancia().lerString();
			Leitura.getInstancia().lerString();
			menuRelatorio();
		}
		
		switch (escolha) {
		case 0:
			menuPrincipal();
			break;
		case 1:
			(new AlterarFile()).RelatorioFinal("Geral");
			(new AlterarFile()).listarPausados();
			System.out.println("Precione Enter Para Continuar");
            Leitura.getInstancia().lerString();
            Leitura.getInstancia().lerString();
            Menu.getInstancia().menuRelatorio();
			break;
		case 2:
			(new AlterarFile()).RelatorioFinal("Vitoria");
			System.out.println("Precione Enter Para Continuar");
            Leitura.getInstancia().lerString();
            Leitura.getInstancia().lerString();
            Menu.getInstancia().menuRelatorio();
			break;
		case 3:
			(new AlterarFile()).RelatorioFinal("Derrotas");
			System.out.println("Precione Enter Para Continuar");
            Leitura.getInstancia().lerString();
            Leitura.getInstancia().lerString();
            Menu.getInstancia().menuRelatorio();
			break;
		default:
			menuRelatorio();
		}

	}

	public void menuPrincipal() {
		Jogo.getInstancia().esvaziarMemoria();//Por enquanto esta aqui, mas vou colocar no lugar certo 

		System.out.println("|1| - Jogar");
		System.out.println("|2| - Gerar relatorios");
		System.out.println("|0| - Sair");
		
		try {
			escolha = Leitura.getInstancia().lerInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite somente numeros\n");
			Leitura.getInstancia().lerString();
			Leitura.getInstancia().lerString();
			menuPrincipal();
		}

		switch (escolha) {
		case 0:
			System.exit(0);
			break;
		case 1:
			ControleGeral.getInstancia().inicioDeJogo();
			break;
		case 2:
			Menu.getInstancia().menuRelatorio();
			break;
		default:
			menuPrincipal();
		}

	}

	public void menuNiveis() {
		
		System.out.println("\n|1| - Facil");
		System.out.println("|2| - Medio");
		System.out.println("|3| - Dificil");
		try {
			escolha = Leitura.getInstancia().lerInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite somente numeros\n");
			Leitura.getInstancia().lerString();
			Leitura.getInstancia().lerString();
			menuNiveis();
		}
		switch (escolha) {
		case 1:
			Nivel nivelFacil = new NivelFacil();
			nivelFacil.aplicarDificuldade();
			System.out.println("O nivel escolhido �: " + nivelFacil.getNivel());
			ControleFile.getInstancia()
					.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelFacil.getNivel());
			break;
		case 2:
			Nivel nivelMedio = new NivelMedio();
			nivelMedio.aplicarDificuldade();
			System.out.println("O nivel escolhido �: " + nivelMedio.getNivel());
			ControleFile.getInstancia()
					.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelMedio.getNivel());

			break;
		case 3:
			Nivel nivelDificil = new NivelDificil();
			nivelDificil.aplicarDificuldade();
			System.out.println("O nivel escolhido �: " + nivelDificil.getNivel());
			ControleFile.getInstancia()
					.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelDificil.getNivel());
			break;
		default:
			menuNiveis();
		}

	}
}
