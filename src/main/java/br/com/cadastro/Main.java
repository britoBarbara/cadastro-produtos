package br.com.cadastro;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.CategoriaCollectionRepository;
import br.com.cadastro.repository.ProdutoCollectionRepository;
import com.sun.source.doctree.SystemPropertyTree;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Produto produto = new Produto();
        produto.setNome("Kindle")
                .setDescricao("e-reader")
                .setPreco(BigDecimal.valueOf(800))
                .setDataDeCadastro(LocalDateTime.now())
                .setCategoria(CategoriaCollectionRepository.findByNome("Eletronicos").get(0));

        Produto produto1 = ProdutoCollectionRepository.save(produto);

        System.out.println("ID: " + produto1.getId() + " Nome do Produto: " + produto1.getNome());
    }
}