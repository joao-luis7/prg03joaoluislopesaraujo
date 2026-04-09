/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.view;

import java.util.Scanner;
/**
 *
 * @author joaol
 */
public class Main {
    public static void main (String[] args){
       Scanner sc = new Scanner(System.in);
       ContaBanco conta = new ContaBanco();
       int opcao;
       
        System.out.println("Bem-vindo ao banco digital");
        
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Abrir Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Pagar Mensalidade");
            System.out.println("5. Fechar conta");
            System.out.println("6. Consultar Saldo");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opcao: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1:
                    if (conta.isStatus()){
                        System.out.println("Voce ja possui uma conta aberta");
                    } else{
                        System.out.println("Tipo de conta (cc ou cp): ");
                        String tipo = sc.nextLine().trim().toLowerCase();
                        
                        System.out.println("Nome do Titular: ");
                        String nome = sc.nextLine();
                        
                        conta.abrirConta(tipo, nome);
                    }
                    break;
                case 2:
                    if (!conta.isStatus()) {
                        System.out.println("Abra uma conta antes de depositar!");
                    } else{
                        System.out.println("Valor para deposito: R$ ");
                        
                        double valorDep = sc.nextDouble();
                        sc.nextLine();
                        conta.depositar(valorDep);
                    }
                    break;
                case 3:
                    if (!conta.isStatus()){
                        System.out.println("Abra uma conta antes de sacar!");
                    } else{
                        System.out.println("Valor para saque: R$ ");
                        double valorSac = sc.nextDouble();
                        sc.nextLine();
                        conta.sacar(valorSac);
                    }
                    break;
                case 4: //pagar mensalidade
                    conta.pagarMensal();
                    break;
                case 5: 
                    conta.fecharConta();
                    break;
                case 6: //consulta de saldo
                    System.out.printf("Saldo atual: R$ %.2f%n", conta.getSaldo());
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (opcao != 0);
        
         sc.close();
    }
}
