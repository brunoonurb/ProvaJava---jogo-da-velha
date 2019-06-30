package br.fapi.poo.provajavajogo.controle;


import br.fapi.poo.provajavajogo.modelo.Jogo;
import br.fapi.poo.provajavajogo.util.Leitura;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
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
            meuBf.write("letrasErradas#" + Jogo.getInstancia().getLetrasPalpites().toString());
            meuBf.newLine();
            meuBf.write("limiteTentativas#" + Jogo.getInstancia().getLimiteTentativas());
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
            while ((linha = meuBr.readLine()) != null){
                    palavra =  linha.split("#");
                for(int i = 0;i < palavra.length;i++){
                    conteudo = palavra[i];
                }
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
                        Jogo.getInstancia().getLetrasErradas().add(conteudo.charAt(i));
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
                }


                System.out.println(Jogo.getInstancia().getPalavra());
                System.out.println(Jogo.getInstancia().getDificuldade());
                System.out.println(Jogo.getInstancia().getNomeJogador());
                System.out.println(Jogo.getInstancia().getLetrasPalpites());
                System.out.println(Jogo.getInstancia().getLetrasErradas());
                System.out.println(Jogo.getInstancia().getLimiteTentativas());
                Leitura.getInstancia().lerString();
                Leitura.getInstancia().lerString();
                ControleJogo.getInstancia().comecarJogo();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void AdicionarRelatorioFinal(){
        File dir = new File("Relatorios");
        dir.mkdir();

        if (Jogo.getInstancia().getEstadoDoJogo().equals("Vitoria")){

            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioVitorias.txt"));
            adicionarRelatorios();

            Jogo.getInstancia().setMyFile(new File(dir,"RelatorioGeral.txt"));
            adicionarRelatorios();
        }else if(Jogo.getInstancia().getEstadoDoJogo().equals("Derrota")){

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
            meuBf.write("letrasErradas#" + Jogo.getInstancia().getLetrasPalpites().toString());
            meuBf.newLine();
            meuBf.write("limiteTentativas#" + Jogo.getInstancia().getLimiteTentativas());
            meuBf.newLine();
            meuBf.write("interrupcoes#" + Jogo.getInstancia().getInterrupcoes());
            meuBf.newLine();
            meuBf.write("dataInicio#" + Jogo.getInstancia().getDataInicio());
            meuBf.newLine();
            meuBf.write("dataFim#" + Jogo.getInstancia().getDataFim());
            meuBf.newLine();
            meuBf.newLine();
            meuBf.flush();

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



}
