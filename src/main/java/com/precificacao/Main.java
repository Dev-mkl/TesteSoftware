package com.precificacao;

import com.precificacao.MateriaPrima;
import com.precificacao.Imposto;
import com.precificacao.Precificacao;

public class Main {
    public static void main(String[] args) {
        MateriaPrima materia = new MateriaPrima("Tecido", 50.00);
        Imposto imposto = new Imposto("ICMS", 10.0);
        Precificacao precificacao = new Precificacao(materia, imposto, 40.0);

        double precoVenda = precificacao.precoVenda();
        System.out.println("Preço de venda: " + precoVenda);
    }
}