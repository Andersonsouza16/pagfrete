package com.devsgc.pagfrete.error;

import java.util.Date;

public class MensagemErro {
    private Date data;
    private String mensagem;

    public MensagemErro(Date data, String mensagem) {
        this.data = data;
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
