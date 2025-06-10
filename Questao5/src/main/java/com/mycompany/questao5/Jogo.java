/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.Questao5;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

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
            do {
                if (todasBolas.isEmpty()) {
                    System.err.println("Erro: Não há bolas suficientes para preencher as pilhas com topos únicos.");
                    return;
                }
                // >>> AQUI É ONDE ELA É INICIALIZADA <<<
                primeiroTopo = todasBolas.remove(0); // <-- Pega e remove a primeira bola da lista embaralhada
                // e a atribui a 'primeiraBolaParaTopo'.
                // Agora a variável tem um valor válido.
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
}
