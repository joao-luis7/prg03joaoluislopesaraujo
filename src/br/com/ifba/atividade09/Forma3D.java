/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public abstract class Forma3D extends Forma{

    public Forma3D(String nome) {
        super(nome);
    }
    
    public abstract double obterArea();
    
    public abstract double obterVolume();
    
    @Override
    public String toString() {
        return super.toString() + " [3D] - Área: " + obterArea() + 
               ", Volume: " + obterVolume();
    }
}
