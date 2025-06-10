/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoa3;

/**
 *
 * @author vm040
 */
public enum CorBola {
    
    Vermelho("Vermelho"),
    Verde("Verde"),
    Azul("Azul"),
    Amarelo("Amarelo"),
    Marrom("Marrom"),
    Laranja("Laranja"),
    Rosa("Rosa");
    
    private String nomeCor;
    
    CorBola(String nomeCor){
        this.nomeCor = nomeCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }
    
    
}
