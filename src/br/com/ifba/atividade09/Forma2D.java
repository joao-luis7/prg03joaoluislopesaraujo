/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public abstract class Forma2D extends Forma{

    public Forma2D(String nome) {
        super(nome); //chama o construtor da classe pai
    }
    
    public abstract double obterArea();

    @Override
    public String toString() {
        return super.toString() + " [2D] - Área: " + obterArea();
    }
    
}
