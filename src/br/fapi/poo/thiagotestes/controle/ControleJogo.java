package br.fapi.poo.thiagotestes.controle;

import br.fapi.poo.thiagotestes.modelo.Jogador;
import br.fapi.poo.thiagotestes.util.Leitura;
import br.fapi.poo.thiagotestes.util.Menu;

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
		Jogador.getInstancia().setNome(Leitura.getInstancia().lerString("Digite o nome do jogador:"));
		Menu.getInstancia().
	}
}
