/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao2;

import java.util.Scanner;
public class main {
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite 1 para jogar sozinho e 2 para jogar com um amigo: ");
        int resposta = ler.nextInt();
        
        if(resposta == 1){
        Jogo meuJogo = new Jogo();
        meuJogo.iniciar();
        }else{
            MultiJogadores jogadores = new MultiJogadores();
            jogadores.iniciar();
        }
    }
}