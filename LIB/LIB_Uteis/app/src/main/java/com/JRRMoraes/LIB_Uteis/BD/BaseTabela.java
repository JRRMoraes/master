package com.JRRMoraes.LIB_Uteis.BD;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.JRRMoraes.LIB_Uteis.GUI.Mensageiro;

import java.util.List;

/**
 * Criado por JohnnyRic em 04/09/2015.
 */
public class BaseTabela {

    private ITabela tabela;


    public BaseTabela(ITabela tabela) {
        this.tabela = tabela;
    }


    public ITabela getTabela() {
        return tabela;
    }


    public int quantidadeCampos() {
        return getTabela().campos().size();
    }


    public String[] arrayNomes() {
        String[] vRetorno = new String[quantidadeCampos()];
        for (int loop = 0; loop < quantidadeCampos(); loop++) {
            vRetorno[loop] = getTabela().campos().get(loop).toString();
        }
        return vRetorno;
    }


    public Boolean criarTabela(SQLiteDatabase db, Context contexto) {
        String vSql = "";
        String vSeparador = "";
        List<Campo> vCampos = getTabela().campos();
        for (Campo vCampo : vCampos) {
            vSql += vSeparador + vCampo.extensoCriacao();
            vSeparador = ",";
        }
        vSql = String.format("CREATE TABLE %s ( %s )", getTabela().nome(), vSql);

        try {
            db.execSQL(vSql);
            return true;
        } catch (Exception e) {
            Mensageiro.errar(contexto, "Ao criar tabela", getTabela().nome(), e);
        }
        return false;
    }


    public Boolean atualizarTabela(SQLiteDatabase db, Context contexto) {
        Cursor vCursor = db.rawQuery(String.format("PRAGMA table_info( %s )", getTabela().nome()), null);
        if (!vCursor.moveToFirst()) {
            return criarTabela(db, contexto);
        }

        String vSql = "";
        List<Campo> vCampos = getTabela().campos();

        //for (Campo vCampo : vCampos) {
        //    vSql += vSeparador +
        //    vSeparador = ",";
        //}

        do {
            try {
                System.out.println("col: " + vCursor.getString(1));

                //db.execSQL(vCampo.extensoAtualizacao(getTabela()));
            } catch (Exception e) {
                Mensageiro.errar(contexto, "Ao atualizar tabela", getTabela().nome(), e);
            }
        } while (vCursor.moveToNext());
        return true;
    }


    public Cursor consultarTodos(MotorBanco motorBanco, String ordenacao) {
        return motorBanco.getDb().query(getTabela().nome(), arrayNomes(), null, null, null, null, ordenacao);
    }


    public Cursor consultarPorSelecao(MotorBanco motorBanco, String selecao, String ordenacao) {
        return motorBanco.getDb().query(getTabela().nome(), arrayNomes(), selecao, null, null, null, ordenacao);
    }
}