package br.fapi.poo.filetestando;


import br.fapi.poo.Util.Leitura;

public class LerNome {
    Leitura ler = new Leitura();

   public String lerNomeUsuario(){
       System.out.println(" NOme do Usuario :");

       return ler.lerString();
   }

}
