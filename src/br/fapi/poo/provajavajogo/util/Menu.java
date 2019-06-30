package br.fapi.poo.provajavajogo.util;

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

	private Menu() {
	}

	public static synchronized Menu getInstancia() {
		if (instancia == null) {
			instancia = new Menu();
		}
		return instancia;
	}

	public void menuPrincipal() {

		System.out.println("|1| - Jogar");
		System.out.println("|2| - Gerar relatorios");
		System.out.println("|0| - Sair");

		int escolha = Leitura.getInstancia().lerInt();
		switch (escolha) {
		case 0:
			System.exit(0);
			break;
		case 1:
			ControleGeral.getInstancia().inicioDeJogo();
			break;
		case 2:
			break;
		default:
			menuPrincipal();
		}

	}

	public void menuNiveis() {
		System.out.println("\n|1| - Facil");
		System.out.println("|2| - Medio");
		System.out.println("|3| - Dificil");
		int escolha = Leitura.getInstancia().lerInt();
		switch (escolha) {
		case 1:
			Nivel nivelFacil = new NivelFacil();
			nivelFacil.aplicarDificuldade();
			System.out.println("O nivel escolhido é: " + nivelFacil.getNivel());
			ControleFile.getInstancia()
					.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelFacil.getNivel());
			break;
		case 2:
			Nivel nivelMedio = new NivelMedio();
			nivelMedio.aplicarDificuldade();
			System.out.println("O nivel escolhido é: " + nivelMedio.getNivel());
			ControleFile.getInstancia()
			.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelMedio.getNivel());
	
			break;
		case 3:
			Nivel nivelDificil = new NivelDificil();
			nivelDificil.aplicarDificuldade();
			System.out.println("O nivel escolhido é: " + nivelDificil.getNivel());
			ControleFile.getInstancia()
			.verificarExistenciaDeJogo(Jogo.getInstancia().getNomeJogador() + nivelDificil.getNivel());
			break;
		default:
			menuNiveis();
		}

	}
}
