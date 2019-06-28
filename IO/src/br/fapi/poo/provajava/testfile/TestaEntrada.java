package br.fapi.poo.provajava.testfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestaEntrada {

    public static void main(String[] args)  throws IOException{
        InputStream is = System.in;
        System.out.print("Digite um texto: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufer = new BufferedReader(isr);

        String digitado = bufer.readLine();

        while(digitado != null){
            System.out.println("Texto Digitado = "+digitado);
            digitado = bufer.readLine();
        }

    }
}
