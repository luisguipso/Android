package com.example.frank.crudandroidsqlite;

/**
 * Created by aluno on 18/05/18.
 */

public class Cartao {
    private Integer id = 0;
    private double credito;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
