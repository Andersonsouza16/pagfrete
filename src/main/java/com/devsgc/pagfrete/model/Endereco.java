package com.devsgc.pagfrete.model;

import javax.persistence.*;

@Entity(name = "endereco_entrega")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "end_municipio")
    private String municipio;
    @Column(name = "end_bairro")
    private String bairro;
    @Column(name = "end_rua")
    private String rua;
    @Column(name = "end_numero")
    private String numero;
    @Column(name = "end_complemento")
    private String complemento;
    @Column(name = "end_cep")
    private String cep;
    @Column(name = "end_ponto_referencia")
    private String pontoReferencia;

    public Endereco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }
}
