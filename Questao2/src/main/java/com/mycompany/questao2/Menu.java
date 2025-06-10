/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
package com.mycompany.Questao2;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Impressora impressoes = new Impressora();
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1) Enviar documento");
            System.out.println("2) Visualizar ordem de impressão");
            System.out.println("3) Sair");
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o título do documento: ");
                    String titulo = leitor.nextLine();
                    System.out.println("1) para documentos URGENTES");
                    System.out.println("2) para documentos INTERMEDIÁRIOS");
                    System.out.println("3) para documentos COMUNS");
                    int tipo = leitor.nextInt();
                    impressoes.enfileira(titulo, tipo);
                    break;
                case 2:
                    System.out.println("Documentos na fila de impressão: ");
                    impressoes.verFila();
                    break;
            }
        } while (opcao != 3);

    }
}
