package br.fapi.poo.provajavajogo.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Jogo {
	private static Jogo instancia;

	private Jogo() {
	}

	public static synchronized Jogo getInstancia() {
		if (instancia == null) {
			instancia = new Jogo();
		}
		return instancia;
	}
	private File myFile;
	private String estadoDoJogo;//PAUSADO , ABANDONADO
	private String nomeJogador;
	private String dificuldade;
	private String palavra;
	private String resultado;
	private int tentativasUsadas=0;
	private int tentativasRestantes;// limite-tentativasusadas
	private int limiteTentativas;
	private String palpite;
	private ArrayList<Character> letrasPalpites = new ArrayList<Character>();
	private ArrayList<Character> letrasErradas = new ArrayList<Character>();
	private int interrupcoes;
	private Date dataInicio;
	private Date dataFim;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getEstadoDoJogo() {
		return estadoDoJogo;
	}

	public void setEstadoDoJogo(String estadoDoJogo) {
		this.estadoDoJogo = estadoDoJogo;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nome) {
		this.nomeJogador = nome;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
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

	public int getTentativasUsadas() {
		return tentativasUsadas;
	}

	public void setTentativasUsadas(int tentativa) {
		this.tentativasUsadas += tentativa;
	}

	public int getTentativasRestantes() {
		return (getLimiteTentativas()-getTentativasUsadas());
	}

	public void setTentativasRestantes(int tentativasRestantes) {
		this.tentativasRestantes = tentativasRestantes;
	}

	public int getLimiteTentativas() {
		return limiteTentativas;
	}

	public void setLimiteTentativas(int limiteTentativas) {
		this.limiteTentativas = limiteTentativas;
	}

	public String getPalpite() {
		return palpite;
	}

	public void setPalpite(String palpite) {
		this.palpite = palpite;
	}

	public ArrayList<Character> getLetrasPalpites() {
		return letrasPalpites;
	}

	public void setLetrasPalpites(ArrayList<Character> letrasPalpites) {
		this.letrasPalpites = letrasPalpites;
	}

	public ArrayList<Character> getLetrasErradas() {
		return letrasErradas;
	}

	public void setLetrasErradas(ArrayList<Character> letrasErradas) {
		this.letrasErradas = letrasErradas;
	}

	public int getInterrupcoes() {
		return interrupcoes;
	}

	public void setInterrupcoes(int interrupcoes) {
		this.interrupcoes += interrupcoes;
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
