/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3trabalho;

import java.util.Date;

public class Documento implements Comparable<Documento> {

    private String nome;
    private int tipo;
    private long tempoDeEnvio;

    public Documento(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.tempoDeEnvio = new Date().getTime(); // Captura o momento da criação
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public long getTempoDeEnvio() {
        return tempoDeEnvio;
    }

    public void setTempoDeEnvio(long tempoDeEnvio) {
        this.tempoDeEnvio = tempoDeEnvio;
    }

    @Override
    public int compareTo(Documento outroDocumento) {
//comparando a prioridade
        int comparaPrioridade = Integer.compare(this.tipo, outroDocumento.tipo);
        if (comparaPrioridade != 0) {
            return comparaPrioridade;
        }
        return Long.compare(this.tempoDeEnvio, outroDocumento.tempoDeEnvio);
    }

    @Override
    public String toString() {
        return "Documentos{" + "nome=" + nome + ", tipo=" + tipo + '}';
    }
}
