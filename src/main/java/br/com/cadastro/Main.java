package br.com.cadastro;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import com.sun.source.doctree.SystemPropertyTree;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Categoria categoria =  new Categoria();
        categoria.setId(1L).setNome("Eletronicos");

        Produto produto = new Produto();
        produto.setId(1L)
                .setNome("Kindle")
                .setDescricao("e-reader")
                .setCategoria(categoria)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(800));

        System.out.println("Categoria:" + categoria);

        System.out.println("Produto:" + produto);


    }
}