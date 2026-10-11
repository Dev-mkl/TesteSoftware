package com.precificacao;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PrecificacaoTest {

    @Test
    void deveCalcularPrecoDeVendaCorretamente() {
        MateriaPrima materia = new MateriaPrima("Tecido", 50.00);
        Imposto imposto = new Imposto("ICMS", 10.0);
        Precificacao precificacao = new Precificacao(materia, imposto, 40.0);

        double precoFinal = precificacao.precoVenda();

        assertThat(precoFinal).isEqualTo(100.00);
    }

    @Test
    void deveLancarExcecaoQuandoMateriaPrimaForNegativa() {
        MateriaPrima materia = new MateriaPrima("Tecido", -10.00);
        Imposto imposto = new Imposto("ICMS", 10.0);
        Precificacao precificacao = new Precificacao(materia, imposto, 40.0);

        IllegalArgumentException excecao = assertThrows(
            IllegalArgumentException.class, 
            () -> precificacao.precoVenda()
        );

        assertThat(excecao.getMessage()).isEqualTo("O valor da matéria prima deve ser positivo");
    }

    @Test
    void deveVerificarItensEOrdemNaListaDeTaxas() {
        MateriaPrima materia = new MateriaPrima("Ferro", 50.00);
        Imposto imposto = new Imposto("ISS", 10.0);
        Precificacao precificacao = new Precificacao(materia, imposto, 40.0);

        double precoVenda = precificacao.precoVenda();

        assertThat(precificacao.getTaxas()).isNotEmpty();
        
        var primeiraTaxaRegistro = precificacao.getTaxas().get(0);

        assertNotNull(precoVenda);
        assertThat(primeiraTaxaRegistro).hasSize(2);
        assertThat(primeiraTaxaRegistro.get(0)).isEqualTo(10.00);
        assertThat(primeiraTaxaRegistro.get(1)).isEqualTo(40.00);
    }
}