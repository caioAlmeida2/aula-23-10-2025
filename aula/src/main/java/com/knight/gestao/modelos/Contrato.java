package com.knight.gestao.modelos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

import java.lang.String;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contrato {
    private UUID id;
    private String instrumentoPrincipal;
    private String dataContrato;

    @XmlTransient //evitar loop circular
    private Banda banda;
    private Musico musico;

    public Contrato() {
    }

    public Contrato(UUID id, String instrumentoPrincipal, String dataContrato, Banda banda, Musico musico) {
        this.id = id;
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.dataContrato = dataContrato;
        this.banda = banda;
        this.musico = musico;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }

    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        this.instrumentoPrincipal = instrumentoPrincipal;
    }

    public String getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(String dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }

}
