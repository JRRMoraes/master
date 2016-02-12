package com.JRRMoraes.LIB_Uteis.BD;


/**
 * Criado por JohnnyRic em 01/09/2015.
 */
public class Campo {

    private String nome;
    private Tipo tipo;
    private Boolean ehChavePrimaria;


    public Campo(String nome, Tipo tipo, Boolean ehChavePrimaria) {
        this.nome = nome;
        this.tipo = tipo;
        this.ehChavePrimaria = ehChavePrimaria;
    }


    public Campo(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.ehChavePrimaria = false;
    }


    public String getNome() {
        return nome;
    }


    public Tipo getTipo() {
        return tipo;
    }


    public Boolean getEhChavePrimaria() {
        return ehChavePrimaria;
    }


    public String extensoCriacao() {
        return String.format("  %s %s %s ",
                getNome(),
                getTipo().toString(),
                (getEhChavePrimaria()) ? "primary key" : "");
    }


    public String extensoAtualizacao(String tabela, Boolean criarCampo) {
        return String.format("ALTER TABLE %s %s COLUMN %s %s ",
                tabela,
                ((criarCampo) ? "ADD" : "ALTER"),
                getNome(),
                getTipo().toString()
                //        ,
                //        (getEhChavePrimaria()) ? "primary key" : ""
        );
    }


    public String toString() {
        return getNome();
    }


    public enum Tipo {

        ID, Inteiro, Flutuante, Longo, DataHora, Booleano, Selecao, Texto, Blob;


        @Override
        public String toString() {
            String vRetorno = "";
            switch (this) {
                case ID:
                    vRetorno = "integer";
                    break;
                case Inteiro:
                    vRetorno = "integer";
                    break;
                case Flutuante:
                    vRetorno = "number";
                    break;
                case Longo:
                    vRetorno = "long";
                    break;
                case DataHora:
                    vRetorno = "date";
                    break;
                case Booleano:
                    vRetorno = "number";
                    break;
                case Selecao:
                    vRetorno = "number";
                    break;
                case Texto:
                    vRetorno = "text";
                    break;
                case Blob:
                    vRetorno = "blob";
                    break;
                default:
                    vRetorno = "text";
                    break;
            }
            return vRetorno;
        }

    }
}