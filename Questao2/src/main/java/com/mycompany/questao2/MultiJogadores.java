/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao2;

import java.util.Scanner;

public class MultiJogadores {

    private Jogo jogador1;
    private Jogo jogador2;

    public MultiJogadores() {
        System.out.println("Inicializando jogo MultiPlayer");
        jogador1 = new Jogo();
        jogador2 = new Jogo();
    }

    public void iniciar() {
        Scanner leitor = new Scanner(System.in);

        int turno = 1;

        while (true) {
            System.out.println("Vez do jogador: " + turno);

            //determina qual Jogo pertence ao jogador do turno
            Jogo jogadorAtual = (turno == 1) ? jogador1 : jogador2;

            jogadorAtual.jogoComeco();

            if (jogadorAtual.vitoria()) {
                System.out.println("Jogador " + turno + " venceu o jogo");
                break;
            }
            System.out.println("Jogador " + turno + "Digite o número da pilha de origem (1- " + jogadorAtual.numPilhas + " ou 0 para sair: ");
            int respostaOrigem = leitor.nextInt();
            if (respostaOrigem == 0) {
                System.out.println("Jogador " + turno + " saiu do jogo");
                int vencedor = (turno == 1) ? 2 : 1;
                System.out.println("Jogador " + vencedor + " venceu por desistência");
                break;
            }

            System.out.println("Jogador " + turno + "Digite o número da pilha de origem (1- " + jogadorAtual.numPilhas + "): ");
            int respostaDestino = leitor.nextInt();

            boolean movimento = jogadorAtual.moverBola(respostaOrigem, respostaDestino);

            if (movimento && jogadorAtual.vitoria()) {
                System.out.println("Jogador " + turno + " venceu o jogo");
                break;
            }

            turno = (turno == 1) ? 2 : 1;
        }

        System.out.println("\nFim do Jogo Multiplayer.");
        leitor.close();
    }
}
