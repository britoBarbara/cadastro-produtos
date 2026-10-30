package br.com.cadastro.view;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.CategoriaCollectionRepository;
import br.com.cadastro.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.lang.String.format;

public class ProdutoView {

    public static Produto form(Produto produto) {
        Categoria categoria = null;

        do {
            categoria = CategoriaView.select(null);
        } while (categoria == null);

        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do Produto", produto.getNome());
        } while (nome.equals(""));

        String descricao = "";
        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a descrição do Produto", produto.getDescricao());
        } while (descricao.equals(""));

        Double p = (double) 0;
        do {
            try {
                p = Double.parseDouble(JOptionPane.showInputDialog("Preço do Produto"));

            } catch (NumberFormatException e) {
                p = (double) 0;
            }
            if (p <= 0) {
                JOptionPane.showMessageDialog(null, "Preço inválido!");
            }

        } while (p <= 0);

        BigDecimal Preco = BigDecimal.valueOf(p);


        Produto ret = new Produto();
        ret.setNome(nome).
                setDescricao(descricao).
                setPreco(BigDecimal.valueOf(p)).
                setDataDeCadastro(LocalDateTime.now()).
                setCategoria(categoria);
        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome().toUpperCase() + " salvo com sucesso!");

    }

    public static Produto select(Produto produto) {
        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione uma produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProdutoCollectionRepository.findAll().toArray(),
                produto == null ? 1 : produto);
        return ret;
    }

    public static void update(Produto produto) {
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto p) {
        System.out.println(p);

        String produtoString = format("PRODUTO: " + p.getNome() + System.lineSeparator() +
                "DESCRIÇÃO: " + p.getDescricao() + System.lineSeparator() +
                "PREÇO: '%,.2f'" + p.getPreco() + System.lineSeparator() +
                "DATA DE CADASTRO: " + p.getDataDeCadastro() + System.lineSeparator() +
                "CATEGORIA: " + p.getCategoria().getNome());
        JOptionPane.showMessageDialog(null, produtoString);
    }

}
