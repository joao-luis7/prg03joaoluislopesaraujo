/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author joaol
 */
public class Usuario {
    private long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private Boolean ativo;
    
    private List<LogAuditoria> logsAuditoria;
    private List<Sessao> sessoes;

    public Usuario() {
        this.ativo = true;
        this.sessoes = new ArrayList<>();
        this.logsAuditoria = new ArrayList<>();
    }

    public Usuario(long id, PerfilUsuario perfil, String nomeUsuario, String email, String senha, Boolean ativo, List<LogAuditoria> logsAuditoria, List<Sessao> sessoes) {
        this.id = id;
        this.perfil = perfil;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.logsAuditoria = new ArrayList<>();
        this.sessoes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<LogAuditoria> getLogsAuditoria() {
        return logsAuditoria;
    }

    public void setLogsAuditoria(List<LogAuditoria> logsAuditoria) {
        this.logsAuditoria = logsAuditoria;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", perfil=" + perfil + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + ", ultimoLogin=" + ultimoLogin + ", ativo=" + ativo + ", logsAuditoria=" + logsAuditoria + ", sessoes=" + sessoes + '}';
    }
    
    public LogAuditoria logar(String senhaDigitada){
        if(!this.isAtivo()){ //verifica se o usuario está ativo
            System.out.println("Usuario inativo. Login não permitido.");
            return null;
        }
        
        //comparação de senha
        if(!this.getSenha().equals(senhaDigitada)){
            System.out.println("Senha Incorreta");
            return null;
        }
        
        //Se chegou aqui, a senha está correta e o usuario ativo
        
        this.setUltimoLogin(LocalDateTime.now()); //vai colocar horario no ultimo login
        
        LogAuditoria novoLog = new LogAuditoria(
                System.currentTimeMillis(), //id gerado com base no tempo
                this,
                "Login realizado com sucesso", 
                this.getUltimoLogin(),
                "127.0.1.0"//ip padrão pq no slide o parametro era apenas a senha
        );
        
        //associa o log ao usuario
        this.getLogsAuditoria().add(novoLog);
        
        //retorna o log criado
        return novoLog;
    }
    
    public Sessao criarSessao(){
        if(!this.isAtivo()){ //verifica se usuario ativo
            System.out.println("Usuario Inativo. Não foi possivel criar sessao");
            return null;
        }
        
        String token = UUID.randomUUID().toString(); //geração de token
        
        //criar nova sessao
        Sessao novaSessao = new Sessao(
                System.currentTimeMillis(), //id
                this, //usuario
                token //token gerado
        );
        
        this.getSessoes().add(novaSessao); //adiciona a sessao criada pra lista dentro do usuario
        
        return novaSessao;
    }
        
}
