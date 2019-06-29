package br.fapi.poo.thiagotestes.controle;

import java.util.Scanner;

import br.fapi.poo.thiagotestes.util.Leitura;
import br.fapi.poo.thiagotestes.util.Menu;

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

	public void inicioDeJogo() {
		String escolha = Leitura.getInstancia().lerString("Gostaria de Jogar?(S/N)");
	
		switch (escolha) {
		case "S":
			ControleJogo.getInstancia().receberNomeJogador();
			break;
		case "N":
			Menu.getInstancia().inicio();

			break;
		}
	}
}
