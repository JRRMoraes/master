package com.JRRMoraes.LIB_Uteis.BD;


public class Cadastro {

    public static final String CHAVE_Situacao = "Cadastro.Situacao";
    public static final String CHAVE_ID = "Cadastro.ID";
    private Requisicao requisicao;
    private String ID = "";


    public Requisicao getRequisicao() {
        return requisicao;
    }


    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }


    public enum Requisicao {

        Visualizar(0), Inserir(1), Editar(2), Excluir(3);
        private final int valor;


        Requisicao(int valor) {
            this.valor = valor;
        }


        public int getValor() {
            return valor;
        }

    }


    public enum Retorno {

        Nao(0), Inserido(1), Editado(2), Excluido(3);
        private final int valor;


        Retorno(int valor) {
            this.valor = valor;
        }


        public int getValor() {
            return valor;
        }

    }

/*    public Requisicao lerIntent(Intent intent) {
        requisicao = Requisicao.Inserir;
        if (intent.hasExtra(CHAVE_Situacao)) {
            requisicao = intent.getIntExtra(CHAVE_Situacao, Requisicao.Inserir.getValor());
        }

        ID = "";
        if (intent.hasExtra(CHAVE_ID)) {
            ID = intent.getStringExtra(CHAVE_ID);
        }

        if (ID.equals("")) {
            requisicao = Inserir;
        }

        return requisicao;
    }
    */
}
