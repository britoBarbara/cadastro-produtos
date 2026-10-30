package br.com.cadastro.view;


import br.com.cadastro.model.Categoria;
import br.com.cadastro.repository.CategoriaCollectionRepository;

import javax.swing.*;

public class CategoriaView {

    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;
    }


    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome().toUpperCase() + " salva com sucesso!");

    }

    public static Categoria form(Categoria categoria) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da Categoria", categoria != null ? categoria.getNome() : "");
        return new Categoria(nome);
    }
}