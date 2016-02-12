package com.JRRMoraes.LIB_Uteis.Funcoes;


/**
 * Criado por JohnnyRic em 04/02/2016.
 */
public class Texto {

    public static Boolean temConteudo(String valor) {
        return ((valor != null) && (!valor.trim().isEmpty()));
    }


    public static String mesclarTextos(String texto1, String separador, String texto2) {
        Boolean vOkTexto1 = temConteudo(texto1);
        Boolean vOkTexto2 = temConteudo(texto2);
        texto1 = (vOkTexto1 ? texto1 : "");
        separador = (temConteudo(separador) ? separador : "");
        texto2 = (vOkTexto2 ? texto2 : "");
        if (vOkTexto1 && vOkTexto2) {
            return texto1 + separador + texto2;
        }
        return texto1 + texto2;
    }
}
