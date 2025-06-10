/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.questao2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
import java.util.Set;
import java.util.Scanner;

public class Jogo {

    int numPilhas = 7;
    int maxBolas = 7;
    int pilhasCheias = 6;

    List<Stack<Bolas>> pilhasBolas;

    public Jogo() {
        iniciarJogo();
    }

    private void iniciarJogo() {

        List<Bolas> todasBolas = new ArrayList<>();

        //Cria as bolas necessárias
        for (CorBola cor : CorBola.values()) {
            for (int i = 0; i < (pilhasCheias * maxBolas) / CorBola.values().length; i++) {
                todasBolas.add(new Bolas(cor));
            }
        }

        //embaralha as cores dentro daspilhas
        Collections.shuffle(todasBolas);

        //cria a estrutura de pilhas onde as bolas ficarão guardadas
        List<Stack<Bolas>> pilhasBolas = new ArrayList<>();
        for (int i = 0; i < numPilhas; i++) {
            pilhasBolas.add(new Stack<>());//cria uma pilha vazia para cada 
        }

        //distribui as bolas nas pilhas e garante os topos diferentes
        Set<CorBola> coresNoTopo = new HashSet<>();

        // Preenche as primeiras pilhasCheias
        for (int i = 0; i < pilhasCheias; i++) {

            Stack<Bolas> pilhaAtual = pilhasBolas.get(i);
            Bolas primeiroTopo;

            //loop para garantir que os topos serão diferentes
            do {
                if (todasBolas.isEmpty()) {
                    System.err.println("Erro: Não há bolas suficientes para preencher as pilhas com topos únicos.");
                    return;
                }
                primeiroTopo = todasBolas.remove(0); //remove a primeira bola da lista embaralhada
            } while (coresNoTopo.contains(primeiroTopo.getCor()));

            pilhaAtual.push(primeiroTopo);  // Adiciona a bola ao topo da pilha
            coresNoTopo.add(primeiroTopo.getCor()); // Registra a cor como já usada no topo

            //Preenche o restante da pilha até a capacidade máxima
            for (int j = 0; j < maxBolas - 1; j++) {
                if (!todasBolas.isEmpty()) { //garante que há bolas disponíveis
                    pilhaAtual.push(todasBolas.remove(0));//adciona a próxima aleatória
                } else {
                    break;
                }
            }
        }

    }

    public void jogoComeco() {
        //mostra o estado inicial das pilhas
        System.out.println("-----Veja como estão os fracos-----");
        for (int i = 0; i < pilhasBolas.size(); i++) {
            System.out.println("Pilha " + (i + 1) + ": ");
            if (pilhasBolas.get(i).isEmpty()) {
                System.out.println("Pilha Vazia");
            } else {
                List<Bolas> bolasNaPilha = new ArrayList<>(pilhasBolas.get(i));
                Collections.reverse(bolasNaPilha);
                System.out.println(bolasNaPilha + " (Topo: " + pilhasBolas.get(i).peek().getCor().getNomeCor() + ")");
            }
        }
    }

    public boolean moverBola(int frascoOrigem, int frascoDestino) {
        //ajusta os indices para a base 0
        frascoOrigem--;
        frascoDestino--;

        Stack<Bolas> origem = pilhasBolas.get(frascoOrigem);
        Stack<Bolas> destino = pilhasBolas.get(frascoDestino);

        if (origem.isEmpty()) {
            System.out.println("Pilha de Origem VAZIA");
            return false;
        }

        if (destino.size() == maxBolas) {
            System.out.println("Pilha de Destino CHEIA");
            return false;
        }

        Bolas bolaMovida = origem.peek();
        if (!destino.isEmpty()) {
            CorBola bolaDestino = destino.peek().getCor();
            if (bolaMovida.getCor() != bolaDestino) {
                System.out.println("Topo INCOMPATÍVEL");
                return false;
            }
        }

        //remove a bola da pilha de orgiem e adiciona na pilha de destino
        bolaMovida = origem.pop();
        destino.push(bolaMovida);
        System.out.println("Bola: " + bolaMovida.getCor().getNomeCor() + "\nMovida do frasco: " + (frascoOrigem + 1) + " Para o frasco: " + (frascoDestino + 1));
        return true;
    }

    public boolean vitoria() {
        //percorre as pilhas para garantir que estão preenchidas corretamente
        for (Stack<Bolas> pilhas : pilhasBolas) {
            //fracos vazios podem ser válidos
            if (pilhas.isEmpty()) {
                continue;
            }

            //as pilhas precisam estar com o número máximo de bolas para estarem resolvidas
            if (pilhas.size() != maxBolas) {
                return false;
            }

            //garante que todas as bolas são if=guais
            CorBola corCerta = pilhas.peek().getCor();
            
            for(Bolas bola : pilhas){
                if(bola.getCor() != corCerta){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void iniciar(){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Bem Vindo ao Jogo");
        
        while(true){
            jogoComeco();
            
            if(vitoria()){
                System.out.println("Você VENCEU");
                break;
            }
            
            System.out.println("Digite o número da pilha de origem (1- " + numPilhas + " ou 0 para sair: ");
            int respostaOrigem = leitor.nextInt();
            if(respostaOrigem == 0){
                System.out.println("Saindo do jogo");
                break;
            }
            
            System.out.println("Digite o número da pilha de destino (1- " + numPilhas + "): ");
            int respostaDestino = leitor.nextInt();
            
            moverBola(respostaOrigem, respostaDestino);
        }
        leitor.close();
    }
}
