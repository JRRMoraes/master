package com.JRRMoraes.LIB_Uteis.BD;


import java.util.List;

public interface IEsquema {

    public String getNomeBancoDados();


    public int getVersaoBancoDados();


    public List<BaseTabela> getTabelas();


    public String getUrlAutorizacao();
}
