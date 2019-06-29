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

         meuBf.write("*|nome|: #" + jogo.nome + "#");
         meuBf.newLine();
            meuBf.write("|dificuldade|: #" + jogo.dificuldade + "#");
            meuBf.newLine();
            meuBf.write("|palavra|: #" + jogo.palavra + "#");
            meuBf.newLine();
            meuBf.write("|resultado|: #" + jogo.resultado + "#");
            meuBf.newLine();
            meuBf.write("|palpite|: #" + jogo.palpite + "#");
            meuBf.newLine();
            meuBf.write("|tentativa|: #" + jogo.tentativa + "#");
            meuBf.newLine();
            meuBf.write("|interrupcoes|: #" + jogo.interrupcoes + "#");
            meuBf.newLine();
            meuBf.write("|dataHoraInicio|: #" + jogo.dataHoraInicio + "#");
            meuBf.newLine();
            meuBf.write("|dataHorafim #" + jogo.dataHorafim + "#*");
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

            while ((minhaSt = meuBr.readLine()) != null){
                System.out.println("oi"+minhaSt);

            }

            String[] user = s.split(";");

            //Criamos um objeto User e setamos em seus atributos
            //as posições correspondentes do array
            User u = new User();
            u.setId(Integer.valueOf(user[0]));
            u.setNome(user[1]);
            u.setObservacao(user[2]);

            //exibe o conteúdo do objeto u
            System.out.println(u.toString())



            //   for (char c :minhaSt){}
          /*  System.out.println("=================================");
            char[] texto =  new char[500];
            int size = meuBr.read(texto);
            System.out.println("LISTANDO O FILE \n");
            for (char c :texto){
                System.out.print(c);*/
            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
