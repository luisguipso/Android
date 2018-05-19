package com.example.frank.crudandroidsqlite;

import java.util.Date;

/**
 * Created by aluno on 18/05/18.
 */

public class Fatura {
    private int id = 0;
    private Cartao cartao;
    private Date vencimento;
    private Date fechamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
