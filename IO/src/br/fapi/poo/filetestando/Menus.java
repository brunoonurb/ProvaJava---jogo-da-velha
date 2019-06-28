package br.fapi.poo.filetestando;

public class Menus {
    br.fapi.poo.banco.Util.Leitura ler = new br.fapi.poo.banco.Util.Leitura();

    public int menuPricipal(){
        System.out.println("|1| atualizar File");
        System.out.println("|2| Listar File");
        System.out.println("|3| Deletar File");
        System.out.println("|0| Encerrar Tudo");

        return ler.lerInt();
    }
}
