package com.example.rodolfo.inlocoweather;

/**
 * Created by Rodolfo on 2/16/2016.
 */
public class Cidade {
    private String nome;
    private double tempMax;
    private double tempMim;
    private String descricao;

    public Cidade (String nome, double tempMax, double tempMim, String descricao){
        this.nome = nome;
        this.tempMax = tempMax;
        this.tempMim = tempMim;
        this.descricao = descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMim(double tempMim) {
        this.tempMim = tempMim;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMim() {
        return tempMim;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}
