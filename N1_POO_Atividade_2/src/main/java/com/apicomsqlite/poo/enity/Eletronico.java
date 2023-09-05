package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Eletronico {

    @Id
    private int id;

    private String nomeModelo;

    private String fabricante;

    private String tipo;

    private String especificacoes;

    private double preco;

    public Eletronico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getFabricate() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "id=" + id +
                ", modelo='" + nomeModelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", tipo='" + tipo + '\'' +
                ", especificacoes='" + especificacoes + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}