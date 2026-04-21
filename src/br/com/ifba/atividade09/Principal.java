/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Principal {
     public static void main(String[] args) {
        // Cria um array de Forma que pode armazenar qualquer subclasse de Forma
        // Polimorfismo: referências do tipo pai apontando para objetos filhos
        Forma[] formas = new Forma[6];
        
        // Preenche o array com objetos das classes concretas
        formas[0] = new Circulo(5.0);           // Raio = 5
        formas[1] = new Quadrado(4.0);          // Lado = 4
        formas[2] = new Triangulo(6.0, 8.0);    // Base = 6, Altura = 8
        formas[3] = new Esfera(3.0);            // Raio = 3
        formas[4] = new Cubo(5.0);              // Aresta = 5
        formas[5] = new Piramide(4.0, 6.0);     // Lado base = 4, Altura = 6
        
        System.out.println("=== RELATÓRIO DE FORMAS GEOMÉTRICAS ===\n");
        
        // Percorre o array processando todas as formas
        for (int i = 0; i < formas.length; i++) {
            System.out.println("--- Forma " + (i + 1) + " ---");
            
            // Exibe a descrição toString do objeto
            System.out.println("Descrição: " + formas[i].toString());
            
            // Verifica o tipo real do objeto usando instanceof
            // instanceof: operador que verifica se um objeto é instância de uma classe
            if (formas[i] instanceof Forma2D) {
                // Se for Forma2D, faz downcasting (conversão para tipo mais específico)
                Forma2D forma2D = (Forma2D) formas[i];
                System.out.println("Tipo: Forma Bidimensional (2D)");
                System.out.println("Área: " + String.format("%.2f", forma2D.obterArea()));
                
            } else if (formas[i] instanceof Forma3D) {
                // Se for Forma3D, faz downcasting
                Forma3D forma3D = (Forma3D) formas[i];
                System.out.println("Tipo: Forma Tridimensional (3D)");
                System.out.println("Área Superficial: " + String.format("%.2f", forma3D.obterArea()));
                System.out.println("Volume: " + String.format("%.2f", forma3D.obterVolume()));
            }
            
            System.out.println(); // Linha em branco para separar
        }
        
        // Demonstração adicional: acessando atributos específicos via getters
        System.out.println("=== ACESSO A ATRIBUTOS ESPECÍFICOS ===\n");
        
        // Exemplo: acessando o raio do círculo (primeiro elemento)
        if (formas[0] instanceof Circulo) {
            Circulo circulo = (Circulo) formas[0];
            System.out.println("Raio do círculo: " + circulo.getRaio());
            System.out.println("Área calculada: " + String.format("%.2f", circulo.obterArea()));
        }
        
        // Exemplo: acessando a aresta do cubo (quinto elemento)
        if (formas[4] instanceof Cubo) {
            Cubo cubo = (Cubo) formas[4];
            System.out.println("Aresta do cubo: " + cubo.getAresta());
            System.out.println("Volume do cubo: " + String.format("%.2f", cubo.obterVolume()));
        }
    }
}
