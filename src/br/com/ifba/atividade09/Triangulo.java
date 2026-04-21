/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Triangulo extends Forma2D{
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        super("Triangulo");
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    

    @Override //calcular area do triangulo (base * altura) / 2
    public double obterArea() {
        return (base * altura) / 2;
    }
    
    @Override
    public String toString() {
        return String.format("Triângulo [Base: %.2f, Altura: %.2f] - Área: %.2f", 
                            base, altura, obterArea());
    }
}
