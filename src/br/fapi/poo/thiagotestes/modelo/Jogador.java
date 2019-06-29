package br.fapi.poo.thiagotestes.modelo;

import java.util.Date;

import br.fapi.poo.thiagotestes.controle.ControleGeral;

public class Jogador {
	private static Jogador instancia;

	private Jogador() {
	}

	public static synchronized Jogador getInstancia() {
		if (instancia == null) {
			instancia = new Jogador();
		}
		return instancia;
	}

	
	private String nome;
	private  String palavra;
	private String resultado;
	private int tentativas;
	private String palpite;
	private int interrupcoes;
	private Date dataInicio;
	private Date dataFim;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getTentativas() {
		return tentativas;
	}
	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}
	public String getPalpite() {
		return palpite;
	}
	public void setPalpite(String palpite) {
		this.palpite = palpite;
	}
	public int getInterrupcoes() {
		return interrupcoes;
	}
	public void setInterrupcoes(int interrupcoes) {
		this.interrupcoes = interrupcoes;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
