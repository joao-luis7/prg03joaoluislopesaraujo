/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.view;

/**
 *
 * @author joaol
 */
public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo = 0.0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    public void abrirConta(String tipo, String dono){
        //Só abre uma nova conta se estiver FECHADA
        if (!this.isStatus()){
            //valida se o tipo de conta (cc ou cp)
            if(tipo.equals("cp") || tipo.equals("cc")){
                this.setTipo(tipo);
                this.setDono(dono);
                this.setStatus(true); //agora a conta está aberta
                
                //bonus de abertura
                if (this.getTipo().equals("cc")){
                    this.setSaldo(50);
                } else{
                    this.setSaldo (150);
                }
                System.out.println("Conta aberta com sucesso!");
            } else{
                System.out.println("ERRO: A conta deve ser do tipo 'cc' ou 'cp'");
            }
        } else{
            System.out.println("ERRO: A conta já está aberta.");
        }
    }
    
    public void fecharConta(){
        if(!this.isStatus()){
            System.out.println("ERRO: A conta precisa estar aberta");
            return;
        }
        if (this.getSaldo() != 0 ){
            System.out.println("ERRO: Sua conta deve estar zerada antes de fechâ-la");
            return;
        }
     
        this.setStatus(false);
        System.out.println("Conta fechada com sucesso!");
    }
    
    public void depositar(double valor){
        
        //veriifca a conta se ta aberta
        if (!this.isStatus()){
            System.out.println("ERRO: A conta precisa estar aberta");
            return;
        }
        //verifica se o valor é positivo
        if (valor <= 0){
            System.out.println("ERRO: Valor inválido. Depósito deve ser maior que zero.");
            return;
        }
        
        //atualiza o saldo
        this.setSaldo(this.getSaldo() + valor); //soma com o valor que já está na conta
        
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        System.out.println("Saldo atual: R$ " + this.getSaldo());
    }
    
    public void sacar(double valor){
        //veriifca a conta se ta aberta
        if (!this.isStatus()){
            System.out.println("ERRO: A conta precisa estar aberta");
            return;
        }
        
        //valor deve ser positivo 
        if (valor <= 0){
            System.out.println("Erro: Valor inválido");
            return;
        }
        
        //Saldo suficiente
        if (this.getSaldo() < valor){
            System.out.println("Saldo Insuficiente");
            return;
        }
       
        //atualiza o saldo
        this.setSaldo(this.getSaldo() - valor); //subtrai o valor do saque da conta
        
        System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        System.out.println("Saldo atual: R$ " + this.getSaldo());
    }
    
    public void pagarMensal(){
        //veriifca a conta se ta aberta
        if (!this.isStatus()){
            System.out.println("ERRO: A conta precisa estar aberta");
            return;
        }
        
        double valor_mensalidade = 0;
        //verificar qual tipo de conta
        if (this.getTipo().equals("cc")){
           valor_mensalidade = 12; //valor da mensalidade descontado
        }else{
            valor_mensalidade = 20; //valor da mensalidade descontado em CP
        }
        this.setSaldo(this.getSaldo() - valor_mensalidade);
        System.out.println("A Mensalidade foi paga com sucesso!");
    }
}
