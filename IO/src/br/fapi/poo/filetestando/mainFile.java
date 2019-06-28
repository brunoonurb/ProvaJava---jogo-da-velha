package br.fapi.poo.filetestando;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mainFile {
    public static void main(String[] args) {
        Menus menus = new Menus();
        LerNome lerNome = new LerNome();


        String usuario = lerNome.lerNomeUsuario();
        File myFile = new File(usuario + ".txt");//criando um biblliteca  file somente
        ControlerFile controle = new ControlerFile();
    int escolha =0;
        do {
            escolha = menus.menuPricipal();
            switch (escolha){
                case 1:
                    controle.criarFile(usuario,myFile);
                    break;

                case 2:
                    controle.lerFile(myFile);
                    break;
                case 3:
                    controle.deletarFile(myFile);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("opcao nao valida");
                    break;
            }

        }while(escolha != 0);






    }
}
