/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MultiJogadores {

    Jogo jogoDisputado;
    Scanner leitor = new Scanner(System.in);
    List<Integer> jogadoresAtivos; //guarda o num de jogadores

    public MultiJogadores() {
        System.out.println("Inicializando jogo MultiPlayer");
        jogoDisputado = new Jogo();//cria o tabuleiro do jogo
        quantJogadores();
        System.out.println("A partida tem " + jogadoresAtivos.size() + " jogadores");
    }

    public void quantJogadores() {
        int maxJogadores = 5;
        int minJogadores = 2;
        int quantInicial;
        
        while (true) {
            System.out.println("Quantos jogadores iram participar?");

            System.out.println("(" + minJogadores + " - " + maxJogadores + ")");
            if (leitor.hasNextInt()) {
                quantInicial = leitor.nextInt();
                if (quantInicial >= minJogadores && quantInicial <= maxJogadores) {
                    break;
                } else {
                    System.out.println("Só são permitidos jogadores de " + minJogadores + " até " + maxJogadores);
                }
            }else{
                System.out.println("Por favor digite um número");
                leitor.next();
            }
        }
        
        //adiciona o numero de jogadores a lista
        jogadoresAtivos = new ArrayList<>();
        for(int i = 1; i <= quantInicial; i++){
        jogadoresAtivos.add(i);
        }
    }

    public void iniciar() {
        int jogadorAtual = 0;

        while (true) {
            
            //verifica se restou somente 1 jogador
            if(jogadoresAtivos.size() == 1){
                int vencedor = jogadoresAtivos.get(0);
                System.out.println("Jogador " + vencedor + " venceu o jogo por desistência");
                break;
            }
            
            //verifica se o jogo foi ganhado na última jogada
            if(jogoDisputado.vitoria()){
                System.out.println("Jogo vencido");
                break;
            }
            
            //garanti que o índice não ultrapasse o limite após a remoção de um jogador
            if(jogadorAtual >= jogadoresAtivos.size()){
                jogadorAtual = 0;
            }
            
            //pega o número do jogador atual
            int turno = jogadoresAtivos.get(jogadorAtual);
            System.out.println("Vez do jogador: " + turno);

            jogoDisputado.jogoComeco();
            
            System.out.println("Jogador " + turno + ": digite o número da pilha de origem (1- " + jogoDisputado.numPilhas + " ou 0 para sair: ");
            int respostaOrigem = leitor.nextInt();
            if (respostaOrigem == 0) {
                System.out.println("Jogador " + turno + " saiu do jogo");
                jogadoresAtivos.remove(turno);
                continue;
            }

            System.out.println("Jogador " + turno + "Digite o número da pilha de destino (1- " + jogoDisputado.numPilhas + "): ");
            int respostaDestino = leitor.nextInt();

            boolean movimento = jogoDisputado.moverBola(respostaOrigem, respostaDestino);

            if (movimento && jogoDisputado.vitoria()) {
                System.out.println("Jogador " + turno + " venceu o jogo");
                break;
            }else if(!movimento){
                System.out.println("Movimento inválido");
                continue;
            }

            jogadorAtual = (jogadorAtual + 1) % jogadoresAtivos.size();
        }

        System.out.println("\nFim do Jogo Multiplayer.");
        leitor.close();
    }
}
