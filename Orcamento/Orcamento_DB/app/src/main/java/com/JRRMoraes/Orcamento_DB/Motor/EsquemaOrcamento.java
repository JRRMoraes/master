package com.JRRMoraes.Orcamento_DB.Motor;


import com.JRRMoraes.LIB_Uteis.BD.IEsquema;
import com.JRRMoraes.LIB_Uteis.BD.ITabela;

import java.util.HashMap;
import java.util.List;

public class EsquemaOrcamento implements IEsquema {

    public ITabela tabelaOrcamento = new ITabela() {
        @Override
        public String nome() {
            return "Orcamento";
        }


        @Override
        public HashMap<String, String> campos() {
            vOrcamento = new HashMap<String, String>();
            vOrcamento.put("IDOrcamento", CAMPO_Longo);
            vOrcamento.put("IEvendedor", CAMPO_Longo);
            vOrcamento.put("IEcliente", CAMPO_Longo);
            vOrcamento.put("IEprazo", CAMPO_Longo);
            vOrcamento.put("Numero", CAMPO_String);
            vOrcamento.put("Situacao", CAMPO_Char);
            vOrcamento.put("DataEmissao", CAMPO_DataHora);
            vOrcamento.put("ValorFlutuante", CAMPO_Flutuante);
            vOrcamento.put("AliquotaFlutuante", CAMPO_Flutuante);
            vOrcamento.put("FluxoFlutuante", CAMPO_Char);
            vOrcamento.put("ValorContabil", CAMPO_Flutuante);
            vOrcamento.put("ValorTotal", CAMPO_Flutuante);
            vOrcamento.put("SituacaoEnvio", CAMPO_Char);
            vOrcamento.put("DataEnvio", CAMPO_DataHora);
            vOrcamento.put("DataEdicao", CAMPO_DataHora);
            return vOrcamento;
        }
    };


    public String bancoDados() {
        return "jmDBOrcamento";
    }


    public String projeto() {
        return "com.JoaoMoraes.VendasPecarpa";
    }


    public int versao() {
        return 1;
    }


    public List<ITabela> tabelas() {
        //    List<ITabela> vTabelas = new List<ITabela>();
        //  vTabelas.add(tabelaOrcamento);
        return null;
    }
}
