package com.devsgc.pagfrete.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoNumero;
    private Long clienteId;
    private Long usuarioInclusaoId;
    private double valorSugerido;
    private double valorPago;
    private String status;
    private Date dataSaida;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Long getUsuarioInclusaoId() {
        return usuarioInclusaoId;
    }

    public void setUsuarioInclusaoId(Long usuarioInclusaoId) {
        this.usuarioInclusaoId = usuarioInclusaoId;
    }

    public Long getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(Long pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Frete() {
    }

}
