/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author joaol
 */
public class Piramide extends Forma3D{
    private double ladoBase;
    private double altura;

    public Piramide(double ladoBase, double altura) {
        super("Piramide");
        this.ladoBase = ladoBase;
        this.altura = altura;
    }

    public double getLadoBase() {
        return ladoBase;
    }

    public void setLadoBase(double ladoBase) {
        this.ladoBase = ladoBase;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //area da piramide: area da base+area dos 4 triangulos laterais 
    @Override
    public double obterArea() {
        //area da base quadrada
        double areaBase = ladoBase * ladoBase;
        
        //calcula a altura do triangulo lateral
        double apotema = Math.sqrt(Math.pow(altura, 2) + Math.pow(ladoBase/2, 2));
        
        //area dos 4 triangulos laterias 
        double areaLateral = 4 * ((ladoBase * apotema) / 2);
        
        return areaBase + areaLateral;
    }

    //vol: (area da base * altura) / 3
    @Override
    public double obterVolume() {
        double areaBase = ladoBase * ladoBase;
        return (areaBase * altura) / 3;
    }
    
    @Override
    public String toString() {
        return String.format("Pirâmide [Lado Base: %.2f, Altura: %.2f] - Área: %.2f, Volume: %.2f", 
                            ladoBase, altura, obterArea(), obterVolume());
    }
}

