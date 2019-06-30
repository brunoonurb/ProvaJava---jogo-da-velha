package br.fapi.poo.provajavajogo.modelo;

import br.fapi.poo.provajavajogo.interfaces.Dificuldade;

public abstract class Nivel implements Dificuldade{
	private String nivel;

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
