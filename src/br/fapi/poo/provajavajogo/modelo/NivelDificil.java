package br.fapi.poo.provajavajogo.modelo;

public class NivelDificil extends Nivel {

	@Override
	public void aplicarDificuldade() {
		super.setNivel("Dificil");
		Jogo.getInstancia().setDificuldade("Dificil");
		Jogo.getInstancia().setLimiteTentativas(3);

	}

}
