/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Objects;

/**
 *
 * @author Felipe Álef
 */
public class Produto {
    // Atributos da Classe
    private String nome;
    private String descricao;
    private double valorDeCompra;
    private double porcentagemDeLucro;
    private int quantidade;

    // Contrutores:
    public Produto() {
    }

    public Produto(String nome, String descricao, double valorDeCompra, double porcentagemDeLucro, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorDeCompra = valorDeCompra;
        this.porcentagemDeLucro = porcentagemDeLucro;
        this.quantidade = quantidade;
    }
    
    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public double getPorcentagemDeLucro() {
        return porcentagemDeLucro;
    }

    public void setPorcentagemDeLucro(double porcentagemDeLucro) {
        this.porcentagemDeLucro = porcentagemDeLucro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    // Sobrescrita dos métodos equals and hashcode

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.valorDeCompra) != Double.doubleToLongBits(other.valorDeCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.porcentagemDeLucro) != Double.doubleToLongBits(other.porcentagemDeLucro)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    
    // Sobrescrita do método toString

    @Override
    public String toString() {
        return "Produto: " + nome + "\nDescricao: " + descricao + "\nValor de Compra: " + valorDeCompra + "\nPorcentagem de lucro: " + porcentagemDeLucro + "\nQuantidade: " + quantidade+"\n" ;
    }
    
    // Método que retorna nome do produto e a quantidade em estoque
    
    public String getNomeEestoque(){
        return "Nome: "+nome+"\nQuantidade: "+quantidade+"\n";
    }
        
    
}
