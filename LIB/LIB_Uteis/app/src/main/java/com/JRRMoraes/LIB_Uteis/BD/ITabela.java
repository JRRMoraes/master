package com.JRRMoraes.LIB_Uteis.BD;


import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

/**
 * Criado por JohnnyRic em 30/08/2015.
 */
public interface ITabela<M> {

    public String nome();


    public List<Campo> campos();

    ///////public List<Campo> ids();


    public ContentValues modeloParaContentValues(M modelo);


    public M cursorParaModelo(Cursor cursor);


    public List<M> cursorParaModelos(Cursor cursor);


    public Boolean validarModelo(MotorBanco motorBanco, M modelo);


    public String clausulaPorID(M modelo);


    public boolean inserir(MotorBanco motorBanco, M modelo);


    public boolean editar(MotorBanco motorBanco, M modelo);


    public boolean excluir(MotorBanco motorBanco, M modelo);

//    public boolean importarRegistrosViaJSON(String json);
}
