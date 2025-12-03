package com.knight.gestao.modelos;

import jakarta.xml.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Musico extends Pessoa {

    private String cpf;
    private Double cache;

    @XmlTransient
    private List<Contrato> contrato;

    public Musico() {
    }

    public Musico(UUID id, String nome, String email, String telefone,
                  String cpf, Double cache) {

        super(id, nome, email, telefone, TipoPessoa.PESSOA_FISICA);
        this.cpf = cpf;
        this.cache = cache;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getCache() {
        return cache;
    }

    public void setCache(Double cache) {
        this.cache = cache;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }
}
