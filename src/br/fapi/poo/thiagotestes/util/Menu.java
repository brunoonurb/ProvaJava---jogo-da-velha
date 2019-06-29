package br.fapi.poo.thiagotestes.util;

import br.fapi.poo.thiagotestes.controle.ControleGeral;

public class Menu {
	private static Menu instancia;

	private Menu() {
	}

// sync, serve para não deixar threads diferentes entrarem e instanciarem a classe
	public static synchronized Menu getInstancia() {
		if (instancia == null) {
			instancia = new Menu();
		}
		return instancia;
	}



	public void inicio() {
		
		System.out.println("1 - Jogar");
		System.out.println("2 - Gerar relatorios");
		System.out.println("0 - Sair");
		
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
		}

	}
	
	
	public void menuNiveis() {
		System.out.println("1 - Facil");
		System.out.println("2 - Medio");
		System.out.println("3 - Dificil");
		
	}
}
