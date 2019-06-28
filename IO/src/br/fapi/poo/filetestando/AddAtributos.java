package br.fapi.poo.filetestando;

public class AddAtributos {
    int interrupcoes=0;
    int tentativa = 0;

    public String nome(String nome){
        String nomeUser = "Nome: #" + nome + "#\n" ;

        return nomeUser;
    }
    public String dificuldade(String dificuldade){
        String dificuldadeUser = "dificuldade: #" + dificuldade + "#\n" ;

        return dificuldadeUser;
    }
    public String palavra(String palavra){
        String palavraUser = "palavra: #" + palavra + "#\n" ;

        return palavraUser;
    }
    public String resultado(String resultado){

        String resultadoUser = "resultado: #" + resultado + "#\n" ;

        return resultadoUser;
    }
    public String tentativa(){

         tentativa++;
        String tentativaUser = "tentativa: #" + tentativa + "#\n" ;

        return tentativaUser;
    }
    public String palpite(String palpite){
        String palpiteUser = "palpite: #" + palpite + "#\n" ;

        return palpiteUser;
    }
    public String interrupcoes(){

        interrupcoes++;
        String interrupcoesUser = "interrupcoes: #" + interrupcoes + "#\n" ;

        return interrupcoesUser;
    }
    public String dataHoraInicio(){

        String dataHoraInicio = "28/06/2019|1:23";
        String dataHoraInicioUser = "dataHoraInicio: #" + dataHoraInicio + "#\n" ;

        return dataHoraInicioUser;
    }
    public String dataHoraFim(){

        String dataHoraFim = "28/06/2019|1:23";

        String dataHoraFimUser = "dataHoraFim: #" + dataHoraFim + "#\n\n" ;

        return dataHoraFimUser;
    }
}
