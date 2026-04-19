/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author joaol
 */

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== INICIANDO TESTES ===\n");

        // ---------------------------------------------------------
        // 1. CRIANDO DEPENDÊNCIAS (PERFIL)
        // ---------------------------------------------------------
        // O Perfil precisa existir ANTES do Usuário
        PerfilUsuario perfil = new PerfilUsuario(
            1L, 
            "Administrador", 
            Arrays.asList("CRIAR", "EDITAR", "EXCLUIR")
        );
        System.out.println("1. Perfil criado: " + perfil.getDescricao());

        // ---------------------------------------------------------
        // 2. CRIANDO O USUÁRIO (Construtor de 8 parâmetros)
        // ---------------------------------------------------------
        Usuario usuario = new Usuario(
            1L,                   // id
            perfil,               // PerfilUsuario
            "joao.luis",          // nomeUsuario
            "joao@ifba.edu.br",   // email
            "123456",             // senha
            true,                 // ativo
            new ArrayList<>(),    // logsAuditoria (lista vazia inicial)
            new ArrayList<>()     // sessoes (lista vazia inicial)
        );
        System.out.println("2. Usuário criado: " + usuario.getNomeUsuario());

        // ---------------------------------------------------------
        // 3. TESTANDO O MÉTODO OPCIONAL: LOGAR
        // ---------------------------------------------------------
        System.out.println("\n--- TESTANDO LOGIN ---");
        
        // Tentativa CORRETA
        System.out.println(">> Tentativa com senha correta...");
        usuario.logar("123456"); 
        
        // Tentativa ERRADA (Para ver o tratamento de erro)
        System.out.println(">> Tentativa com senha errada...");
        usuario.logar("senhaerrada");

        // ---------------------------------------------------------
        // 4. TESTANDO O MÉTODO OPCIONAL: CRIAR SESSÃO
        // ---------------------------------------------------------
        System.out.println("\n--- TESTANDO SESSÃO ---");
        
        // Chama o método que gera o token
        Sessao sessao1 = usuario.criarSessao();
        
        if (sessao1 != null) {
            System.out.println(">> Sessão criada com sucesso!");
            System.out.println("   Token gerado: " + sessao1.getToken());
        }

        // ---------------------------------------------------------
        // 5. VALIDAÇÃO FINAL (Prova de que os relacionamentos funcionaram)
        // ---------------------------------------------------------
        System.out.println("\n=== RELATÓRIO FINAL ===");
        
        // Verifica se o Login atualizou o último login
        System.out.println("Último login registrado em: " + usuario.getUltimoLogin());
        
        // Verifica se o LogAuditoria foi adicionado automaticamente na lista
        System.out.println("Quantidade de Logs de Auditoria: " + usuario.getLogsAuditoria().size());
        
        // Verifica se a Sessão foi adicionada automaticamente na lista
        System.out.println("Quantidade de Sessões Ativas: " + usuario.getSessoes().size());
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}