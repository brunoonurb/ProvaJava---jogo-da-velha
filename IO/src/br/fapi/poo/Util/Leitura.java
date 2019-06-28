package br.fapi.poo.banco.Util;

import java.util.Scanner;

public class Leitura {
    Scanner ler = new Scanner(System.in);

    public String lerString() {
        return ler.nextLine();
    }

    public String lerString(String mensagem) {
        System.out.println(mensagem);
        return ler.nextLine();
    }

    public int lerInt() {
        return ler.nextInt();
    }

    public int lerInt(String mensagem) {
        System.out.println(mensagem);
        return ler.nextInt();
    }

    public double lerDouble() {
        return ler.nextDouble();
    }

    public double lerDouble(String mensagem) {
        System.out.println(mensagem);
        return ler.nextDouble();
    }

    public float lerFloat() {
        return ler.nextFloat();
    }

    public float lerFloat(String mensagem) {
        System.out.println(mensagem);
        return ler.nextFloat();
    }

    public boolean lerBoolean(){

        int var = ler.nextInt();

        while (var != 0 && var != 1 ){
            System.out.println("Numero invalido |0| ou |1|");
            var = ler.nextInt();
        }
        boolean bool;
        if (var == 1){
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public boolean lerBoolean(String mensagem){
        System.out.println(mensagem);
        int var = ler.nextInt();
        while (var != 0 && var != 1 ){
            System.out.println("Numero invalido |0| ou |1|");
            var = ler.nextInt();
        }
        boolean bool;
        if (var == 1){
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public String[] lerVetorString(int tamanhoVetor) {
        String[] vetor = new String[10];
        int cont = 0;
        for (String aux : vetor) {
            aux = lerString("Entre com " + (cont++) + " elemento");
        }
        return vetor;
    }

    public double[] lerVetorDouble(double[] vetor) {
        int cont = 0;
        for (double aux : vetor) {
            aux = lerDouble("Entre com " + (cont++) + " elemento");
        }
        return vetor;
    }
    public void pausa(){
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.print("  Precione enter para continuar: \n");
            ler.nextLine();

    }

}
