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
public class PagamentoCartao implements Pagamento {
    
    private double valor;

    //construtor
    public PagamentoCartao(double valor) {
        this.valor = valor;
    }
    //metodo get
    public double getValor() {
        return valor;
    }
    //metodo set
    public void setValor(double valor) {
        this.valor = valor;
    }
   
    @Override
    public double calcularTotal() {
        return this.getValor()*1.05; //valor total somado com uma taxa de 5%
    }

    @Override
    public void imprimirRecibo() {
        double taxa = this.calcularTotal() - this.getValor();
        
        String recibo = """
        =====================
          RECIBO - CARTÃO
        =====================
        Valor: R$ %.2f
        Taxa (5%%): +R$ %.2f
        ---------------------
        TOTAL: R$ %.2f
        =====================
        """.formatted(this.getValor(), taxa, this.calcularTotal());
        
        JOptionPane.showMessageDialog(null, recibo, "Pagamento no cartão", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
