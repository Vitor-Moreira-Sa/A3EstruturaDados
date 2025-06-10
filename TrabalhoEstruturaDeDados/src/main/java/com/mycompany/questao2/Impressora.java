/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
package com.mycompany.Questao2;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Impressora {

    PriorityQueue<Documento> filaImpressao = new PriorityQueue<>();

    public void enfileira(String nome, int tipo) {
        Documento novoDocumento = new Documento(nome, tipo);
        filaImpressao.add(novoDocumento);
        System.out.println(novoDocumento + " adicionado à fila de impressão");
    }

    public void verFila() {
        if (filaImpressao.isEmpty()) {
            System.out.println("Fila de impressão vazia");
            return;
        }
        List<Documento> Docs = new ArrayList<>();
        while (!filaImpressao.isEmpty()) {
            Documento impress = filaImpressao.poll();
            Docs.add(impress);
            System.out.println(impress);
        }
        for (Documento impress : Docs) {
            filaImpressao.add(impress);
        }
    }

}
