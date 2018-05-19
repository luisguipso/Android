package com.example.frank.crudandroidsqlite;

/**
 * Created by aluno on 20/04/18.
 */

public class Lancamento {

    private Integer id;
    private String descricao;
    private Double valorLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }
}
