package br.com.cadastro;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.CategoriaCollectionRepository;
import br.com.cadastro.repository.ProdutoCollectionRepository;
import br.com.cadastro.view.CategoriaView;
import br.com.cadastro.view.Opcao;
import br.com.cadastro.view.OpcaoView;
import br.com.cadastro.view.ProdutoView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Opcao opcao = null;

        do {
            opcao = OpcaoView.select();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_PROGRAMA -> encerrarPrograma();
            }


        } while (opcao != Opcao.ENCERRAR_PROGRAMA);
    }

    private static void encerrarPrograma() {
        System.exit(0);
    }

    private static void consultarProdutoPorCategoria() {

    }

    private static void consultarProdutoPorId() {
    }

    private static void alterarProduto() {
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void cadastrarCategoria() {

        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);

    }
}
