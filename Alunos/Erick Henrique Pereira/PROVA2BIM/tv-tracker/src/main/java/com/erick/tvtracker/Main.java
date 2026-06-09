package com.erick.tvtracker;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.erick.tvtracker.service.UsuarioService;
import com.erick.tvtracker.ui.TelaPrincipal;

public class Main {

    public static void main(String[] args) {

        // garante que a interface gráfica seja criada na thread correta do Swing
        SwingUtilities.invokeLater(() -> {

            UsuarioService usuarioService = new UsuarioService();

            // se for a primeira vez (sem nome salvo), pede o nome do usuário
            if (usuarioService.getUsuario().getNome() == null ||
                usuarioService.getUsuario().getNome().isEmpty()) {

                String nome = null;

                // fica pedindo até o usuário digitar algum nome
                while (nome == null || nome.trim().isEmpty()) {
                    nome = JOptionPane.showInputDialog(
                            null,
                            "Bem-vindo ao TV Tracker!\nDigite seu nome ou apelido:",
                            "Primeiro acesso",
                            JOptionPane.QUESTION_MESSAGE
                    );
                }

                usuarioService.setNomeUsuario(nome.trim());
            }

            TelaPrincipal tela = new TelaPrincipal(usuarioService);
            tela.setVisible(true);
        });
    }
}