package br.fapi.poo.provajavajogo.controle;

import br.fapi.poo.provajavajogo.modelo.Jogo;
import br.fapi.poo.provajavajogo.util.Leitura;
import br.fapi.poo.provajavajogo.util.Menu;

public class ControleGeral {
	private static ControleGeral instancia;

	private ControleGeral() {
	}

	public static synchronized ControleGeral getInstancia() {
		if (instancia == null) {
			instancia = new ControleGeral();
		}
		return instancia;
	}
	public void inicio() {
		Menu.getInstancia().menuPrincipal();
	}

	public void inicioDeJogo() {
		String escolha;
		do {
			escolha = Leitura.getInstancia().lerString("Gostaria de Jogar?(S/N): ");
			escolha = escolha.toUpperCase();
		} while (!((escolha.equals("S")) || (escolha.equals("N"))));
		switch (escolha) {
		case "S":
			ControleJogo.getInstancia().receberNomeJogador();
			break;
		case "N":
			Menu.getInstancia().menuPrincipal();
			break;
		}
	}
	
	
}
