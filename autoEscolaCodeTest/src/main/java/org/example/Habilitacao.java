package org.example;

import java.util.Calendar;

public class Habilitacao {

    final int idadeRenovacao = 50;
    final int idadeMinima = 18;
    final int  validaCNH = 5;
    String habilitado;
    String exit;
    int idade;
    int anoExpedicao;
    Calendar cal = Calendar.getInstance();
    String exame;



    public Habilitacao(Integer idade, String habilitado, Integer anoExpedicao, String exame) {
        if(!(habilitado.equals("N") || habilitado.equals("S"))){
            throw new IllegalArgumentException("Valor informado inválido");
        }
        this.exame = exame;
        this.idade = idade;
        this.habilitado = habilitado;
        this.anoExpedicao = anoExpedicao;
    }
    String exameRealizado() {
        if(exame.equals("sim")){
            exit = "Aprovado";
        }else{
            exit = "Reprovado";
        }
        return exit;
    }
    String ControleIdadeHabilitacao(){
        int time = (cal.get(Calendar.YEAR)-anoExpedicao);


        if(habilitado.equals("S")){
            if(idade < idadeMinima){
                exit = "Não apto";
            } else if(idade >= idadeMinima){
                exit = exameRealizado();
            }
        } else if(habilitado.equals("N")){

                if((idade < idadeRenovacao) && (time >= validaCNH)){
                    exit = exameRealizado();
                }else if(idade >= idadeRenovacao && (time >= (2*validaCNH))){
                    exit = exameRealizado();
                }else{
                    exit = "Não nescessário renovar";
                }

        }

        return exit;
    }
}
