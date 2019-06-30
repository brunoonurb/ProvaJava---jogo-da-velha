package br.fapi.poo.provajavajogo.modelo;

public class NivelMedio extends Nivel {

	@Override
	public void aplicarDificuldade() {
		super.setNivel("Medio");
		Jogo.getInstancia().setDificuldade("Medio");
		Jogo.getInstancia().setLimiteTentativas(5);

	}

}
