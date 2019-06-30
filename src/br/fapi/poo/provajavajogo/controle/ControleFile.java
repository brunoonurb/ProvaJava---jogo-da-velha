package br.fapi.poo.provajavajogo.controle;

import java.io.File;

import br.fapi.poo.provajavajogo.modelo.Jogo;

public class ControleFile {
	private static ControleFile instancia;

	private ControleFile() {
	}

	public static synchronized ControleFile getInstancia() {
		if (instancia == null) {
			instancia = new ControleFile();
		}
		return instancia;
	}
	
	public void verificarExistenciaDeJogo(String arquivoNome) {
		System.out.println("Nome do arquivo é: " + arquivoNome);
		Jogo.getInstancia().setMyFile(new File(arquivoNome+"txt"));
		if (Jogo.getInstancia().getMyFile().exists()) {
			System.out.println("Arquivo existe");
			ControleJogo.getInstancia().continuarAbandonarJogo();
		} else {
			System.out.println("Arquivo não existe \n");
			ControleJogo.getInstancia().criarNovoJogo();
			ControleJogo.getInstancia().inserirPalavra();
		}

	}

}
