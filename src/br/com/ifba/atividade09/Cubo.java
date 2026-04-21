/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Cubo extends Forma3D{

    private double aresta;

    public Cubo(double aresta) {
        super("Cubo");
        this.aresta = aresta;
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }
    
    
    
    @Override // area do cubo: 6 * aresta^2
    public double obterArea() {
        return 6 * aresta * aresta;
    }

    //volume do cubo: aresta^3
    @Override
    public double obterVolume() {
        return Math.pow(aresta, 3);
    }
    
    @Override
    public String toString() {
        return String.format("Cubo [Aresta: %.2f] - Área: %.2f, Volume: %.2f", 
                            aresta, obterArea(), obterVolume());
    }
}
