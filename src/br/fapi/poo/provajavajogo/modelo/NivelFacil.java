package br.fapi.poo.provajavajogo.modelo;

public class NivelFacil extends Nivel {

	@Override
	public void aplicarDificuldade() {
		super.setNivel("Facil");
		Jogo.getInstancia().setDificuldade("Facil");
		Jogo.getInstancia().setLimiteTentativas(7);
	}

}
