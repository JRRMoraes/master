package com.JRRMoraes.Orcamento_DB.Modelos;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CLIENTE.
 */
public class Cliente {

    private Long id;
    private Long Nome;
    private Long CpfCnpj;
    private Long Contato;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(Long id, Long Nome, Long CpfCnpj, Long Contato) {
        this.id = id;
        this.Nome = Nome;
        this.CpfCnpj = CpfCnpj;
        this.Contato = Contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNome() {
        return Nome;
    }

    public void setNome(Long Nome) {
        this.Nome = Nome;
    }

    public Long getCpfCnpj() {
        return CpfCnpj;
    }

    public void setCpfCnpj(Long CpfCnpj) {
        this.CpfCnpj = CpfCnpj;
    }

    public Long getContato() {
        return Contato;
    }

    public void setContato(Long Contato) {
        this.Contato = Contato;
    }

}