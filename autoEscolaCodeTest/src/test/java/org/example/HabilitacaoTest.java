package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HabilitacaoTest {
    @Test
    public void testarCampoHabilitacaoInvalido(){
        try {
            Habilitacao pessoaHab = new Habilitacao(18, "s", 2018, "Aprovado");
            pessoaHab.ControleIdadeHabilitacao();
            fail();
        } catch (RuntimeException e) {
            assertEquals("Valor informado inválido", e.getMessage());
        }
    }

    @Test
    public void testarCampoHabilitacaoValido(){
            Habilitacao pessoaHab = new Habilitacao(18, "S", 2018, "sim");
            assertEquals("Aprovado", pessoaHab.ControleIdadeHabilitacao());
    }

    @Test
    public void idadeInvalidaParaHabilitar(){
        Habilitacao pessoaHab = new Habilitacao(17, "S", 2022, "");
        assertEquals("Não apto", pessoaHab.ControleIdadeHabilitacao());
    }
    @Test
    public void idadeValidaParaHabilitar(){
        Habilitacao pessoaHab = new Habilitacao(19, "S", 2022, "Aprovado");
        assertEquals("Apto", pessoaHab.ControleIdadeHabilitacao());
    }
    @Test
    public void validadeDaHabilitacaoDentroDoPraso(){
        Habilitacao pessoaHab = new Habilitacao(19, "N", 2020, "Aprovado");
        assertEquals("Não nescessário renovar", pessoaHab.ControleIdadeHabilitacao());
    }
    @Test
    public void validadeDaHabilitacaoExpiradaMenos50(){
        Habilitacao pessoaHab = new Habilitacao(35, "N", 2015, "Aprovado");
        assertEquals("Aprovado", pessoaHab.ControleIdadeHabilitacao());
    }

    @Test
    public void validadeDaHabilitacaoExpiradaMais50(){
        Habilitacao pessoaHab = new Habilitacao(51, "N", 2015, "");
        assertEquals("Não nescessário renovar", pessoaHab.ControleIdadeHabilitacao());
    }

    @Test
    public void validadeDaHabilitacaoExpiradaSuperiorA10(){
        Habilitacao pessoaHab = new Habilitacao(51, "N", 2010, "sim");
        assertEquals("Aprovado", pessoaHab.ControleIdadeHabilitacao());
    }

    @Test
    public void validadeDaHabilitacaoExpiradaSuperiorA10ExameReprovado(){
        Habilitacao pessoaHab = new Habilitacao(51, "N", 2010, "não");
        assertEquals("Reprovado", pessoaHab.ControleIdadeHabilitacao());
    }



}