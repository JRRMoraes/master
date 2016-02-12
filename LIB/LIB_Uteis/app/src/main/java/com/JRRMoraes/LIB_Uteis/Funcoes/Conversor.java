package com.JRRMoraes.LIB_Uteis.Funcoes;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Criado por João Ricardo Rodrigues de Moraes em 18/10/2015.
 */
public class Conversor {

    public static String dataParaString(Date data) {
        if (data == null) {
            return null;
        }

        SimpleDateFormat vFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return vFormato.format(data);
    }


    public static Date stringParaData(String data) {
        if (Texto.temConteudo(data)) {
            return null;
        }
        try {
            SimpleDateFormat vFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            return vFormato.parse(data);
        } catch (ParseException e) {
            return null;
        }
    }
}
