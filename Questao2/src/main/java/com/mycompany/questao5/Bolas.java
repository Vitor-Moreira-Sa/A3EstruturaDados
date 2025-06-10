/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Questao5;

/**
 *
 * @author vm040
 */
public class Bolas {
    
    private CorBola cor;
    
    public Bolas(CorBola cor){
        this.cor = cor;
    }

    public CorBola getCor() {
        return cor;
    }
    
    @Override
    public String toString(){
        return "Bola(" + cor.getNomeCor() + ")";
    }
}
