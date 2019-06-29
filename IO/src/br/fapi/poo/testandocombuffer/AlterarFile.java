package br.fapi.poo.testandocombuffer;

import br.fapi.poo.Util.Leitura;

import java.io.*;

public class AlterarFile {
    Leitura ler = new Leitura();


    public File criarArquivo(String nome,String dificuldade){

        File meuFile = new File(nome + dificuldade + ".txt");

        return meuFile;
    }

    public void inserirFile(Jogo jogo){
        try(BufferedWriter meuBf = new BufferedWriter(new FileWriter(jogo.fileJogador))){

            meuBf.write("&nome& #" + jogo.nome + "#");
            meuBf.newLine();
            meuBf.write("&dificuldade& #" + jogo.dificuldade + "#");
            meuBf.newLine();
            meuBf.write("&palavra& #" + jogo.palavra + "#");
            meuBf.newLine();
            meuBf.write("&resultado& #" + jogo.resultado + "#");
            meuBf.newLine();
            meuBf.write("&palpite& #" + jogo.palpite + "#");
            meuBf.newLine();
            meuBf.write("&tentativa& #" + jogo.tentativa + "#");
            meuBf.newLine();
            meuBf.write("&interrupcoes& #" + jogo.interrupcoes + "#");
            meuBf.newLine();
            meuBf.write("&dataHoraInicio& #" + jogo.dataHoraInicio + "#");
            meuBf.newLine();
            meuBf.write("&dataHorafim& #" + jogo.dataHorafim + "#");
            meuBf.newLine();
            meuBf.newLine();
            meuBf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void visualizar(Jogo jogo){

        try(BufferedReader meuBr = new BufferedReader(new FileReader(jogo.fileJogador))){


            String minhaSt ;
            String[] palavra;
            String[] palavra1;
            String nomes = "";
            String contem = "";

            while ((minhaSt = meuBr.readLine()) != null){

                    palavra =  minhaSt.split("#");
                for(int i = 0;i < palavra.length;i++){
                  //  System.out.println("Campo "+i+": "+palavra[i]);
                    nomes = palavra[i];
                }

                palavra1 =  minhaSt.split("&");
                for(int i = 0;i < palavra1.length;i++){
                 //   System.out.println("Conteudo"+i+": "+palavra1[i]);
                    contem = palavra1[i];
                }
                System.out.println("nomes ->" + nomes);
                System.out.println("contem ->" + contem);




            }

            //   for (char c :minhaSt){}
          /*  System.out.println("=================================");
            char[] texto =  new char[500];
            int size = meuBr.read(texto);
            System.out.println("LISTANDO O FILE \n");
            for (char c :texto){
                System.out.print(c);*/

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
