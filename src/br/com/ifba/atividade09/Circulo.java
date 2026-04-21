/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Circulo extends Forma2D{
    private double raio;

    public Circulo(double raio) {
        super("Circulo");
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    //calcular area do circulo: pi * r^2
    
    @Override
    public double obterArea(){
        return Math.PI * raio * raio;
    }
    
    @Override // toString sobrescrito com informações específicas do Círculo
    public String toString() {
        return String.format("Círculo [Raio: %.2f] - Área: %.2f", 
                            raio, obterArea());
    }
}
