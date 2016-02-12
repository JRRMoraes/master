package com.JRRMoraes.LIB_Uteis.BD;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MotorBanco {

    private static IEsquema esquema;
    private final Context contexto;
    private AjudanteAbertura ajudanteAbertura;
    private SQLiteDatabase db;


    public MotorBanco(Context contexto, IEsquema esquema) {
        this.contexto = contexto;
        this.esquema = esquema;
        this.ajudanteAbertura = new AjudanteAbertura(this.contexto);
    }


    public IEsquema getEsquema() {
        return esquema;
    }


    public Context getContexto() {
        return contexto;
    }


    public SQLiteDatabase getDb() {
        abrir();
        return db;
    }


    public Boolean abrir() throws SQLException {
        if ((db == null) || (!db.isOpen())) {
            db = ajudanteAbertura.getWritableDatabase();
        }
        return db.isOpen();
    }


    public void fechar() {
        ajudanteAbertura.close();
    }


    private class AjudanteAbertura extends SQLiteOpenHelper {

        AjudanteAbertura(Context contexto) {
            super(contexto, getEsquema().getNomeBancoDados(), null, getEsquema().getVersaoBancoDados());
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            for (BaseTabela vTabela : getEsquema().getTabelas()) {
                vTabela.criarTabela(db, MotorBanco.this.getContexto());
            }
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            for (BaseTabela vTabela : getEsquema().getTabelas()) {
                vTabela.atualizarTabela(db, MotorBanco.this.getContexto());
            }
        }
    }
}