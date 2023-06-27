package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.SerieDAO;
import Model.Serie;

public class Principal {
    private static SerieDAO serieDAO;

    public static void main(String[] args) {
        serieDAO = new SerieDAO();

        final JFrame frame = new JFrame("Programa Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JButton botaoInserir = new JButton("Inserir Série");
        JButton botaoAtualizar = new JButton("Atualizar Série");
        JButton botaoExcluir = new JButton("Excluir Série");
        JButton botaoConsultar = new JButton("Consultar Séries");
        JButton botaoSair = new JButton("Sair");

        frame.add(botaoInserir);
        frame.add(botaoAtualizar);
        frame.add(botaoExcluir);
        frame.add(botaoConsultar);
        frame.add(botaoSair);

        botaoInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(frame, "Digite o título da série:");
                String genero = JOptionPane.showInputDialog(frame, "Digite o gênero da série:");
                String descricao = JOptionPane.showInputDialog(frame, "Digite a descrição da série:");
                int temporada = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o número de temporadas da série:"));

                Serie serie = new Serie(titulo, genero, descricao, temporada);
                serieDAO.inserirSerie(serie);

                JOptionPane.showMessageDialog(frame, "Série inserida com sucesso!");
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o ID da série a ser atualizada:"));
                Serie serieExistente = serieDAO.consultarSeriePorId(id);

                if (serieExistente != null) {
                    String titulo = JOptionPane.showInputDialog(frame, "Digite o novo título da série:", serieExistente.getTitulo());
                    String genero = JOptionPane.showInputDialog(frame, "Digite o novo gênero da série:", serieExistente.getGenero());
                    String descricao = JOptionPane.showInputDialog(frame, "Digite a nova descrição da série:", serieExistente.getDescricao());
                    int temporada = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o novo número de temporadas da série:", serieExistente.getTemporada()));

                    Serie serieAtualizada = new Serie(titulo, genero, descricao, temporada);
                    serieAtualizada.setId(id);
                    serieDAO.atualizarSerie(serieAtualizada);

                    JOptionPane.showMessageDialog(frame, "Série atualizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Série não encontrada!");
                }
            }
        });

        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o ID da série a ser excluída:"));
                Serie serieExistente = serieDAO.consultarSeriePorId(id);

                if (serieExistente != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir a série?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        serieDAO.excluirSerie(id);
                        JOptionPane.showMessageDialog(frame, "Série excluída com sucesso!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Série não encontrada!");
                }
            }
        });

        botaoConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Serie> series = serieDAO.consultarSeries();
                if (!series.isEmpty()) {
                    StringBuilder mensagem = new StringBuilder("Lista de Séries:\n");
                    for (Serie serie : series) {
                        mensagem.append(serie.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, mensagem.toString());
                } else {
                    JOptionPane.showMessageDialog(frame, "Não existem séries cadastradas!");
                }
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
