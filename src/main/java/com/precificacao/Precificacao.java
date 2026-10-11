package com.precificacao;

import java.util.ArrayList;
import java.util.List;

public class Precificacao {
    private MateriaPrima materiaPrima;
    private Imposto imposto;
    private double lucroPercentual;
    private List<List<Double>> taxas;

    public Precificacao(MateriaPrima materiaPrima, Imposto imposto, double lucroPercentual){
        this.materiaPrima = materiaPrima;
        this.imposto = imposto;
        this.lucroPercentual = lucroPercentual;
        this.taxas = new ArrayList<>();
    }

    public double precoVenda(){
        verificaClasses();

        double porcentagemTotal = (imposto.getValorPercentual() + lucroPercentual) / 100.0;

        if(porcentagemTotal >= 1.0){
            throw new IllegalArgumentException("A soma das taxas e do lucro não pode ser maior ou igual a 100%");
        }

        double precoCalculado = materiaPrima.getValor() / (1.0 - porcentagemTotal);

            
        List<Double> registroTaxa = new ArrayList<>();
        registroTaxa.add((imposto.getValorPercentual() / 100.0) * precoCalculado);
        registroTaxa.add((lucroPercentual / 100.0) * precoCalculado);
        taxas.add(registroTaxa);

        return Math.round(precoCalculado * 100.0) / 100.0;
    }

    public void verificaClasses(){
        if(materiaPrima == null){
            throw new IllegalArgumentException("A matéria prima não pode ser nula");
        }

        if(materiaPrima.getValor() <= 0){
            throw new IllegalArgumentException("O valor da matéria prima deve ser positivo");
        }

        if(imposto == null){
            this.imposto = new Imposto("Imposto", 0);
        }

        if(imposto.getValorPercentual() < 0){
            throw new IllegalArgumentException("O valor do imposto não pode ser negativo");
        }

        if(lucroPercentual < 0){
            throw new IllegalArgumentException("O valor do lucro não pode ser negativo");
        }
    }


    public List<List<Double>> getTaxas() {
        return taxas;
    }
}