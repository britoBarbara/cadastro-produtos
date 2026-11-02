package br.com.cadastro.repository;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static br.com.cadastro.repository.CategoriaCollectionRepository.save;

public class ProdutoCollectionRepository {

    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();

        Produto celular = new Produto();

        celular.setNome("Iphone 14 Pro Max")
                .setDescricao("Aparelho celular da Apple")
                .setCategoria(CategoriaCollectionRepository.findByNome("Celulares").get(0))
                .setPreco(BigDecimal.valueOf(12000));


        Arrays.asList(celular).forEach(ProdutoCollectionRepository::save);
    }

    public static List<Produto> findAll() {
        return produtos;
    }

    public static Produto save(Produto produto) {
        if (!produtos.contains(produto)) {
            produto.setId((long) produtos.size() + 1);
            produtos.add(produto);

            return produto;
        } else {
            JOptionPane.showMessageDialog(null, "Produto já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .toList();
    }

}
