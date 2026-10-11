package com.precificacao;

public class MateriaPrima {
    private String nome;
    private double valor;
    
    public MateriaPrima(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

}