package br.fapi.poo.provajavajogo.controle;


import br.fapi.poo.provajavajogo.modelo.Jogo;
import br.fapi.poo.provajavajogo.util.Leitura;
import br.fapi.poo.provajavajogo.util.Menu;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlterarFile {


    public void criarArquivo(){
        try(BufferedWriter meuBf = new BufferedWriter(new FileWriter(Jogo.getInstancia().getMyFile()))){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            if (Jogo.getInstancia().getDataInicio() == null){
                Jogo.getInstancia().setDataInicio(dateFormat.format(date));
                Jogo.getInstancia().setDataFim(dateFormat.format(date));
            }else {
                Jogo.getInstancia().setDataFim(dateFormat.format(date));
            }
            String palavra="";
            String erradas ="";
            for(int i= 0 ; i< Jogo.getInstancia().getLetrasPalpites().size();i++) {
            	palavra += Jogo.getInstancia().getLetrasPalpites().get(i);
            }
            for(int i= 0 ; i< Jogo.getInstancia().getLetrasErradas().size();i++) {
            	erradas += Jogo.getInstancia().getLetrasErradas().get(i);
            }
            meuBf.write("nome#" + Jogo.getInstancia().getNomeJogador());
            meuBf.newLine();
            meuBf.write("palavra#" + Jogo.getInstancia().getPalavra());
            meuBf.newLine();
            meuBf.write("dificuldade#" + Jogo.getInstancia().getDificuldade());
            meuBf.newLine();
            meuBf.write("resultado#" + Jogo.getInstancia().getEstadoDoJogo());
            meuBf.newLine();
            meuBf.write("letrasPalpites#" + palavra);
            meuBf.newLine();
            meuBf.write("letrasErradas#" + erradas);
            meuBf.newLine();
            meuBf.write("limiteTentativas#" + Jogo.getInstancia().getLimiteTentativas());
            meuBf.newLine();
            meuBf.write("TentativasUsadas#" + Jogo.getInstancia().getTentativasUsadas());
            meuBf.newLine();
            meuBf.write("nChances#" + Jogo.getInstancia().getTentativasRestantes());
            meuBf.newLine();
            meuBf.write("interrupcoes#" + Jogo.getInstancia().getInterrupcoes());
            meuBf.newLine();
            meuBf.write("dataInicio#" + Jogo.getInstancia().getDataInicio());
            meuBf.newLine();
            meuBf.write("dataFim#" + Jogo.getInstancia().getDataFim());
            meuBf.newLine();
            meuBf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void coletarDados(){
    	
    	try(BufferedReader meuBr = new BufferedReader(new FileReader(Jogo.getInstancia().getMyFile()))){

            String linha ;
            String[] palavra;
            String conteudo = "";
            while ((linha = meuBr.readLine()) != null) {
                palavra = linha.split("#");
                for (int i = 0; i < palavra.length; i++) {
                    conteudo = palavra[i];
                }
                System.out.println(palavra[0] + "-> " + conteudo);
                
                
                if (palavra[0].equals("nome")){
                    Jogo.getInstancia().setNomeJogador(conteudo);
                }else if (palavra[0].equals("palavra")){
                    Jogo.getInstancia().setPalavra(conteudo);
                }else if (palavra[0].equals("dificuldade")){
                    Jogo.getInstancia().setDificuldade(conteudo);
                }else  if (palavra[0].equals("resultado")){
                    Jogo.getInstancia().setEstadoDoJogo(conteudo);
                }else  if (palavra[0].equals("limiteTentativas")){
                    Jogo.getInstancia().setLimiteTentativas(Integer.parseInt(conteudo));
                }else  if (palavra[0].equals("letrasPalpites")){
                	
                    for (int i = 0; i < conteudo.length() ; i++) {
                        Jogo.getInstancia().getLetrasPalpites().add(conteudo.charAt(i));
                    }
                }else  if (palavra[0].equals("letrasErradas")){
                    for (int i = 0; i < conteudo.length() ; i++) {
                        Jogo.getInstancia().getLetrasErradas().add(conteudo.charAt(i));
                    }
                }else  if (palavra[0].equals("tentativasUsadas")){
                  Jogo.getInstancia().setTentativasUsadas(Integer.parseInt(conteudo));
                }else  if (palavra[0].equals("interrupcoes")){
                    Jogo.getInstancia().setInterrupcoes(Integer.parseInt(conteudo));
                }else  if (palavra[0].equals("dataInicio")){
                    Jogo.getInstancia().setDataInicio(conteudo);
                }else  if (palavra[0].equals("dataFim")){
                    Jogo.getInstancia().setDataFim(conteudo);
                }else  if (palavra[0].equals("TentativasUsadas")){
                    Jogo.getInstancia().setTentativasUsadas(Integer.parseInt(conteudo));
                }else  if (palavra[0].equals("nChances")){
                    Jogo.getInstancia().setTentativasRestantes(Integer.parseInt(conteudo));
                }
                
            }
            ControleJogo.getInstancia().comecarJogo();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public void AdicionarRelatorioFinal(){
        File dir = new File("Relatorios");
        dir.mkdir();

        if (Jogo.getInstancia().getEstadoDoJogo().equals("Vitoria")){
        	
        	Jogo.getInstancia().getMyFile().delete();
            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioVitorias.txt"));
            adicionarRelatorios();

            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioGeral.txt"));
            adicionarRelatorios();
        }else if(Jogo.getInstancia().getEstadoDoJogo().equals("Derrota")){
        	
        	Jogo.getInstancia().getMyFile().delete();
            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioDerrotas.txt"));
            adicionarRelatorios();

            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioGeral.txt"));
            adicionarRelatorios();

        }
    }

    public void RelatorioFinal(String relatorio){
        File dir = new File("Relatorios");
        dir.mkdir();

        if (relatorio.equals("Vitoria")){
        	
            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioVitorias.txt"));
            listarRelarios();

        }else if (relatorio.equals("Derrota")){
        	
            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioDerrotas.txt"));
            listarRelarios();

        } else{
        	
            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioGeral.txt"));
            listarRelarios();
        }
    }

    public void adicionarRelatorios(){

        try(BufferedWriter meuBf = new BufferedWriter(new FileWriter(Jogo.getInstancia().getMyFile(),true))){

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Jogo.getInstancia().setDataFim(dateFormat.format(date));


            meuBf.write("nome#" + Jogo.getInstancia().getNomeJogador());
            meuBf.newLine();
            meuBf.write("palavra#" + Jogo.getInstancia().getPalavra());
            meuBf.newLine();
            meuBf.write("dificuldade#" + Jogo.getInstancia().getDificuldade());
            meuBf.newLine();
            meuBf.write("resultado#" + Jogo.getInstancia().getEstadoDoJogo());
            meuBf.newLine();
            meuBf.write("letrasPalpites#" + Jogo.getInstancia().getLetrasPalpites().toString());
            meuBf.newLine();
            meuBf.write("letrasErradas#" + Jogo.getInstancia().getLetrasErradas().toString());
            meuBf.newLine();
            meuBf.write("limiteTentativas#" + Jogo.getInstancia().getLimiteTentativas());
            meuBf.newLine();
            meuBf.write("interrupcoes#" + Jogo.getInstancia().getInterrupcoes());
            meuBf.newLine();
            meuBf.write("TentativasUsadas#" + Jogo.getInstancia().getTentativasUsadas());
            meuBf.newLine();
            meuBf.write("nChances#" + Jogo.getInstancia().getTentativasRestantes());
            meuBf.newLine();
            meuBf.write("dataInicio#" + Jogo.getInstancia().getDataInicio());
            meuBf.newLine();
            meuBf.write("dataFim#" + Jogo.getInstancia().getDataFim());
            meuBf.newLine();
            meuBf.write("----------------------------------");
            meuBf.newLine();
            meuBf.newLine();
            meuBf.flush();
            meuBf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listarRelarios(){

        try(BufferedReader meuBr = new BufferedReader(new FileReader(Jogo.getInstancia().getMyFile()))){

            String linha ;
            String[] palavra;
            String conteudo = "";
            while ((linha = meuBr.readLine()) != null) {
                palavra = linha.split("#");
                for (int i = 0; i < palavra.length; i++) {
                    conteudo = palavra[i];
                }
                System.out.println(palavra[0] + "-> " + conteudo);
            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void listarPausados() {
    	
    	 File folder = new File("JogoIniciado\\");
    	 String dir = "C:\\Workplace\\ProvaJava\\JogoIniciado\\";
        
      
    	    File[] listOfFiles = folder.listFiles();

    	    for (int i = 0; i < listOfFiles.length; i++) {
    	        if (listOfFiles[i].isFile()) {
    	            System.out.println("Este é Arquivo " + listOfFiles[i].getName());
    	            
    	            	File arquivo =new File(dir,listOfFiles[i].getName());
    	            	
    	            	  System.out.println(arquivo.exists());
    	            
    	            try(BufferedReader meuBr = new BufferedReader(new FileReader(arquivo))){

    	                String linha ;
    	                String[] palavra;
    	                String conteudo = "";
    	                while ((linha = meuBr.readLine()) != null) {
    	                    palavra = linha.split("#");
    	                    for (int j = 0; j < palavra.length; j++) {
    	                        conteudo = palavra[j];
    	                    }
    	                    System.out.println(palavra[0] + "-> " + conteudo);
    	                }

    	            } catch (FileNotFoundException e) {
    	                e.printStackTrace();
    	            } catch (IOException e) {
    	                e.printStackTrace();
    	            }
    	            
    	            
    	            
    	        } else if (listOfFiles[i].isDirectory()) {
    	            //lista as subpastas
    	            }
    	        }
    }



}
