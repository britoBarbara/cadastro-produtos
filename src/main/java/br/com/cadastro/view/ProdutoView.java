package br.com.cadastro.view;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProdutoView {

    public static Produto form(Produto produto) {
        Categoria categoriaInicial = produto != null ? produto.getCategoria() : null;
        Categoria categoria = CategoriaView.select(categoriaInicial);
        if (categoria == null) {
            return null;
        }

        String nomeInicial = (produto != null && produto.getNome() != null) ? produto.getNome() : "";
        String nome = JOptionPane.showInputDialog(null, "Informe o nome do Produto", nomeInicial);
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        String descInicial = (produto != null && produto.getDescricao() != null) ? produto.getDescricao() : "";
        String descricao = JOptionPane.showInputDialog(null, "Informe a descrição do Produto", descInicial);
        if (descricao == null || descricao.trim().isEmpty()) {
            return null;
        }

        String precoInicial = (produto != null && produto.getPreco() != null) ? produto.getPreco().toString() : "";
        String precoStr = JOptionPane.showInputDialog(null, "Informe o preço do Produto", precoInicial);
        if (precoStr == null || precoStr.trim().isEmpty()) {
            return null;
        }

        BigDecimal preco;
        try {
            preco = new BigDecimal(precoStr.trim().replace(",", "."));
            if (preco.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(null, "Preço inválido! O valor deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Produto alvo = produto != null ? produto : new Produto();
        alvo.setNome(nome.trim())
                .setDescricao(descricao.trim())
                .setPreco(preco)
                .setCategoria(categoria);

        if (alvo.getDataDeCadastro() == null) {
            alvo.setDataDeCadastro(LocalDateTime.now());
        }

        return alvo;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
    }

    public static void sucesso(Produto produto) {
        String nome = (produto != null && produto.getNome() != null) ? produto.getNome().toUpperCase() : "";
        JOptionPane.showMessageDialog(null, "Produto " + nome + " salvo com sucesso!");
    }

    public static Produto select(Produto produto) {
        List<Produto> produtos = ProdutoCollectionRepository.findAll();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione um produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                produtos.toArray(),
                produto != null ? produto : produtos.get(0));
        return ret;
    }

    public static void update(Produto produto) {
        if (produto == null) {
            return;
        }
        Produto atualizado = form(produto);
        if (atualizado != null) {
            sucesso(atualizado);
            show(atualizado);
        }
    }

    public static void show(Produto p) {
        if (p == null) {
            return;
        }
        System.out.println(p);

        String dataStr = p.getDataDeCadastro() != null
                ? p.getDataDeCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                : "Não informada";

        String categoriaStr = p.getCategoria() != null ? p.getCategoria().getNome() : "Sem categoria";

        String produtoString = String.format(
                "PRODUTO: %s%nDESCRIÇÃO: %s%nPREÇO: R$ %,.2f%nDATA DE CADASTRO: %s%nCATEGORIA: %s",
                p.getNome(),
                p.getDescricao(),
                p.getPreco(),
                dataStr,
                categoriaStr
        );
        JOptionPane.showMessageDialog(null, produtoString);
    }
}
