/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

/**
 *
 * @author Lucas Lima
 */
public class Aluno {
    private String nome;
    private double nota1;
    private double frequencia;
    private double trabalho;
    private double projeto;
    private double notafinal;
    private double m1;
    private String situacao;
    
    /**
     * construtor da classe aluno, ou seja, para criar um aluno precisa passar os parametros abaixo
     * @param nome 
     * @param nota1
     * @param frequencia
     * @param trabalho
     * @param projeto
     * @param notafinal
     * @param m1
     * @param situacao 
     */

    public Aluno(String nome, double nota1, double frequencia, double trabalho, double projeto, double notafinal, double m1, String situacao) {
        this.nome = nome;
        this.nota1 = nota1;
        this.frequencia = frequencia;
        this.trabalho = trabalho;
        this.projeto = projeto;
        this.notafinal = notafinal;
        this.situacao = situacao;
        this.m1 = m1;
    }

    public double getM1() {
        return m1;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public double getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public double getProjeto() {
        return projeto;
    }

    public void setProjeto(double projeto) {
        this.projeto = projeto;
    }

    public double getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(double notafinal) {
        this.notafinal = notafinal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
    
    
}
