package com.knight.gestao.modelos;

import jakarta.xml.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Banda extends Pessoa {

    private String cnpj;
    private String generoMusical;

    @XmlElementWrapper(name = "membros")
    @XmlElement(name = "contrato")
    private List<Contrato> membros;

    public Banda() {
    }

    public Banda(UUID id, String nome, String email, String telefone,
                 String cnpj, String generoMusical) {
        super(id, nome, email, telefone, TipoPessoa.PESSOA_JURIDICA);
        this.cnpj = cnpj;
        this.generoMusical = generoMusical;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Contrato> getMembros() {
        return membros;
    }

    public void setMembros(List<Contrato> membros) {
        this.membros = membros;
    }
}
