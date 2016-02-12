package com.JRRMoraes.LIB_Uteis.BD;


import android.database.Cursor;

import com.JRRMoraes.LIB_Uteis.Funcoes.Conversor;

import java.util.Date;

/**
 * Criado por JohnnyRic em 18/10/2015.
 */
public class TabelaUteis {

    public Long obterIdDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return cursor.getLong(vColuna);
        }
        return null;
    }


    public String obterStringDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return cursor.getString(vColuna);
        }
        return "";
    }


    public int obterInteiroDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return cursor.getInt(vColuna);
        }
        return 0;
    }


    public double obterFlutuanteDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return cursor.getFloat(vColuna);
        }
        return 0;
    }


    public Long obterLongDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return cursor.getLong(vColuna);
        }
        return null;
    }


    public Boolean obterBooleanDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return (cursor.getInt(vColuna) == 1);
        }
        return false;
    }


    public Date obterDataDoCursor(Cursor cursor, String nomeDaColuna) {
        int vColuna = cursor.getColumnIndex(nomeDaColuna);
        if (vColuna >= 0) {
            return Conversor.stringParaData(cursor.getString(vColuna));
        }
        return null;
    }


    public enum CadastroRequisicao {

        Visualizar(0), Inserir(1), Editar(2), Excluir(3);
        private final int valor;


        CadastroRequisicao(int valor) {
            this.valor = valor;
        }


        public int getValor() {
            return valor;
        }

    }


    public enum CadastroRetorno {

        Nao(0), Inserido(1), Editado(2), Excluido(3);
        private final int valor;


        CadastroRetorno(int valor) {
            this.valor = valor;
        }


        public int getValor() {
            return valor;
        }

    }





/*

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


public Requisicao lerIntent(Intent intent) {
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