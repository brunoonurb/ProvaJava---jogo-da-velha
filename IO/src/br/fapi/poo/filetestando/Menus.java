package br.fapi.poo.filetestando;

import br.fapi.poo.Util.Leitura;

public class Menus {
    Leitura ler = new Leitura();

    public int menuPricipal(){
        System.out.println("|1| atualizar File");
        System.out.println("|2| Listar File");
        System.out.println("|3| Deletar File");
        System.out.println("|0| Encerrar Tudo");

        return ler.lerInt();
    }
}
