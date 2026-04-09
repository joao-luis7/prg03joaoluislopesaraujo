/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade05.view;

/**
 *
 * @author joaol
 */
public class Fatorial {
    private int valor = 0;
    private int resultado = 1;
    String formula = "";
    
    public void setValor(int n){
        valor = n;
    }
    
    public int getFatorial(){
        //resultado da conta de fatorial
        for (int i = valor; i > 1; i--){
            resultado *= i;
        }
        return resultado;
    }
    
    public String getFormula(){
        for (int i = valor; i >= 1; i--){
            formula = formula + i;
            if (i > 1){
                formula = formula + " x ";
            }
        }
        return formula;
    }
}
