package br.com.cadastro.view;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.repository.CategoriaCollectionRepository;

import javax.swing.*;
import java.util.List;

public class CategoriaView {

    public static Categoria select(Categoria categoria) {
        List<Categoria> categorias = CategoriaCollectionRepository.findAll();
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias.toArray(),
                categoria != null ? categoria : categorias.get(0));
        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
    }

    public static void sucesso(Categoria categoria) {
        String nome = (categoria != null && categoria.getNome() != null) ? categoria.getNome().toUpperCase() : "";
        JOptionPane.showMessageDialog(null, "Categoria " + nome + " salva com sucesso!");
    }

    public static Categoria form(Categoria categoria) {
        String valorInicial = (categoria != null && categoria.getNome() != null) ? categoria.getNome() : "";
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da Categoria", valorInicial);
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        if (categoria != null) {
            categoria.setNome(nome.trim());
            return categoria;
        }
        return new Categoria(nome.trim());
    }

    public static Categoria form(String categoriaNome) {
        return form(categoriaNome != null && !categoriaNome.isEmpty() ? new Categoria(categoriaNome) : null);
    }
}
