/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

import javax.swing.JOptionPane;

/**
 *
 * @author joaol
 */
public class PagamentoDinheiro implements Pagamento{
    
    private double valor;

    public double getValor() { //construtor
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }
    
    
    
    @Override
    public double calcularTotal() {
        return this.getValor()*0.9; //valor total com 10% de desconto equivale a 90% do valor real
    }

    @Override
    public void imprimirRecibo() {
        double desconto = this.getValor() - this.calcularTotal();
        String recibo = """
        =====================
           RECIBO - DINHEIRO
        =====================
        Valor Original: R$ %.2f
        Desconto (10%%): -R$ %.2f
        ---------------------
        TOTAL: R$ %.2f
        =====================
        """.formatted(this.getValor(), desconto, this.calcularTotal());
        
        JOptionPane.showMessageDialog(null, recibo, "Pagamento em Dinheiro", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
