package br.com.cadastro;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.CategoriaCollectionRepository;
import br.com.cadastro.repository.ProdutoCollectionRepository;
import br.com.cadastro.view.CategoriaView;
import br.com.cadastro.view.Opcao;
import br.com.cadastro.view.OpcaoView;
import br.com.cadastro.view.ProdutoView;

import javax.swing.*;
import java.util.List;

import static br.com.cadastro.repository.ProdutoCollectionRepository.findByCategoria;

public class Main {
    public static void main(String[] args) {

        Opcao opcao;

        do {
            opcao = OpcaoView.select();
            if (opcao == null || opcao == Opcao.ENCERRAR_PROGRAMA) {
                break;
            }
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_PROGRAMA -> {}
            }

        } while (opcao != Opcao.ENCERRAR_PROGRAMA);
    }

    private static void consultarProdutoPorCategoria() {
        Categoria categoria = CategoriaView.select(null);
        if (categoria == null) {
            return;
        }

        List<Produto> produtos = findByCategoria(categoria);

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para a categoria " + categoria.getNome());
        } else {
            produtos.forEach(ProdutoView::show);
        }
    }

    private static void consultarProdutoPorId() {
        String input = JOptionPane.showInputDialog(null, "Informe o ID do Produto");
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        try {
            Long id = Long.parseLong(input.trim());
            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "ID inválido! Deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Produto p = ProdutoCollectionRepository.findById(id);
            if (p != null) {
                ProdutoView.show(p);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select(null);
        if (produto != null) {
            ProdutoView.update(produto);
        }
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        if (produto == null) {
            return;
        }
        Produto salvo = ProdutoCollectionRepository.save(produto);
        if (salvo != null) {
            ProdutoView.sucesso(salvo);
        }
    }

    private static void cadastrarCategoria() {
        Categoria categoria = CategoriaView.form(new Categoria());
        if (categoria == null) {
            return;
        }
        Categoria salva = CategoriaCollectionRepository.save(categoria);
        if (salva != null) {
            CategoriaView.sucesso(salva);
        } else {
            JOptionPane.showMessageDialog(null, "Categoria já cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
