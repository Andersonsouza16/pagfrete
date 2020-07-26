package com.devsgc.pagfrete.model;

public class Frete {
    private int id;
    private int numeroPedido;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    private Long clienteId;
    private double valorSugerido;
    private double ValorPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    public double getValorPago() {
        return ValorPago;
    }

    public void setValorPago(double valorPago) {
        ValorPago = valorPago;
    }

    public Frete() {
    }

}
