package br.fapi.poo.provajavajogo.controle;


import br.fapi.poo.provajavajogo.modelo.Jogo;

import java.io.*;

public class AlterarFile {


    public void criarArquivo(){
        try(BufferedWriter meuBf = new BufferedWriter(new FileWriter(Jogo.getInstancia().getMyFile()))){

            meuBf.write("nome#" + Jogo.getInstancia().getNomeJogador());
            meuBf.newLine();
            meuBf.write("dificuldade#" + Jogo.getInstancia().getDificuldade());
            meuBf.newLine();
            meuBf.write("resultado#" + Jogo.getInstancia().getResultado());
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
                  //  System.out.println("Campo "+i+": "+palavra[i]);
                    conteudo = palavra[i];
                }
                System.out.println("conteudo ->" + conteudo);
                if (palavra[0].equals("nome")){
                    Jogo.getInstancia().setNomeJogador(conteudo);
                }else  if (palavra[0].equals("dificuldade")){
                    Jogo.getInstancia().setDificuldade(conteudo);
                }else  if (palavra[0].equals("palavra")){
                    Jogo.getInstancia().setPalavra(conteudo);
                }else  if (palavra[0].equals("resultado")){
                    Jogo.getInstancia().setResultado(conteudo);
                }else  if (palavra[0].equals("limiteTentativas")){
                  //  Jogo.getInstancia().setLimiteTentativas(conteudo);
                }else  if (palavra[0].equals("letrasPalpites")){
                    //Jogo.getInstancia().setLetrasPalpites(String.copyValueOf(conteudo));
                }else  if (palavra[0].equals("letrasErradas")){
                   // Jogo.getInstancia().setLetrasErradas(conteudo);
                }else  if (palavra[0].equals("tentativasUsadas")){
                  // / Jogo.getInstancia().setTentativasUsadas(conteudo);
                }else  if (palavra[0].equals("interrupcoes")){
                   // Jogo.getInstancia().setInterrupcoes(conteudo);
                }else  if (palavra[0].equals("dataInicio")){
                    Jogo.getInstancia().setDataInicio(conteudo);
                }else  if (palavra[0].equals("dataFim")){
                    Jogo.getInstancia().setDataFim(conteudo);
                }



        Jogo.getInstancia().toString();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
