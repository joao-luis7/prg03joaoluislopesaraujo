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
public class PagamentoPix implements Pagamento{
    
    private double valor;

    public PagamentoPix(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    

    @Override
    public double calcularTotal() {
        return this.getValor() * 0.98; //cashback de 2% aplicado o usuario só paga 98% do valor
    }

    @Override
    public void imprimirRecibo() {
        double cashback = this.getValor() - this.calcularTotal();
        
        String recibo = """
        =====================
           RECIBO - PIX
        =====================
        Valor Original: R$ %.2f
        Cashback (2%%): R$ %.2f
        ---------------------
        TOTAL: R$ %.2f
        =====================
        """.formatted(this.getValor(), cashback, this.calcularTotal());
        
        JOptionPane.showMessageDialog(null, recibo, "Pagamento PIX", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
