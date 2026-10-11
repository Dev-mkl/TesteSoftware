package com.precificacao;

public class Imposto {
    private String tipoTaxa;
    private double valorPercentual;

    public Imposto(String tipoTaxa, double valorPercentual){
        this.tipoTaxa = tipoTaxa;
        this.valorPercentual = valorPercentual;
    }

    public String getTipoTaxa(){
        return this.tipoTaxa;
    }

    public void setTipoTaxa(String tipoTaxa){
        this.tipoTaxa = tipoTaxa;
    }

    public double getValorPercentual(){
        return this.valorPercentual;
    }

    public void setValorPercentual(double valorPercentual){
        this.valorPercentual = valorPercentual;
    }
}