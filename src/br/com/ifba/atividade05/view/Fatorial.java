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
    private int valor = 0;        // numero que queremos calcular
    private int resultado = 1;    // onde guardamos o resultado final (começa em 1)
    String formula = "";          // txt que mostrara a conta passo a passo

    // define qual numero será usado para o cálculo
    public void setValor(int n){
        valor = n;
    }
    
    // realiza o calculo matematico do fatorial
    public int getFatorial(){
        // começa do número escolhido e vai multiplicando até chegar em 2
        for (int i = valor; i > 1; i--){
            resultado *= i; // resultado = resultado * i
        }
        return resultado;
    }
    
    // monta a string que explica a conta
    public String getFormula(){
        for (int i = valor; i >= 1; i--){
            formula = formula + i; // add o número atual ao texto
            
            // se nao for o último número (1), adiciona o símbolo de x
            if (i > 1){
                formula = formula + " x ";
            }
        }
        return formula;
    }
}
