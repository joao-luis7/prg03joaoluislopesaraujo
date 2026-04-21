/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Esfera extends Forma3D{
    
    private double raio;

    public Esfera(double raio) {
        super("Esfera");
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    @Override //calcula area da esfera: 4 * pi * r^2
    public double obterArea() {
        return 4 * Math.PI * raio * raio;
    }

    @Override
    public double obterVolume() { //volume da esfera: (4/3) * pi * r^3
        return (4.0/3.0) * Math.PI * Math.pow(raio, 3);
    }
    
     @Override
    public String toString() {
        return String.format("Esfera [Raio: %.2f] - Área: %.2f, Volume: %.2f", 
                            raio, obterArea(), obterVolume());
    }
    
}
