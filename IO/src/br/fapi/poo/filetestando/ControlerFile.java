package br.fapi.poo.filetestando;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControlerFile {
    AddAtributos texto =new AddAtributos();

    public void criarFile(String usuario, File myFile){//so test



        try {
            if (myFile.exists()) {
                for (int i = 0; i < 5; i++) {

                    System.out.println("if");
                    System.out.println(myFile.exists());
                    FileWriter fwriter = new FileWriter(myFile);
                    fwriter.write(texto.nome(usuario));
                    fwriter.write(texto.dificuldade("facil"));
                    fwriter.write(texto.palavra("massa"));
                    fwriter.write(texto.resultado("inicio"));
                    fwriter.write(texto.tentativa());
                    fwriter.write(texto.palpite("o"));
                    fwriter.write(texto.interrupcoes());
                    fwriter.write(texto.dataHoraInicio());
                    fwriter.write(texto.dataHoraFim());
                    fwriter.flush();
                    fwriter.close();

                }


            } else {
                System.out.println(myFile.exists());
                System.out.println("else");
                FileWriter fwriter = new FileWriter(myFile);
                fwriter.write(texto.nome(usuario));
                fwriter.write(texto.dificuldade("facil"));
                fwriter.write(texto.palavra("vai"));
                fwriter.write(texto.resultado("passa"));
                fwriter.write(texto.tentativa());
                fwriter.write(texto.palpite("o"));
                fwriter.write(texto.interrupcoes());
                fwriter.write(texto.dataHoraInicio());
                fwriter.write(texto.dataHoraFim());

                throw new IOException();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void lerFile(File myFile) {

        try {
            if (myFile.exists()) {

                FileReader fileReader = new FileReader(myFile);

                char[] texto =  new char[500];

                int size = fileReader.read(texto);

                System.out.println("LISTANDO O FILE \n");

                for (char c :texto){
                    System.out.print(c);
                }


            }else{
                System.out.println("vazio");
            }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void deletarFile( File myFile) {//so test
        System.out.println(myFile.delete());
    }
}
