package br.com.cadastro;

import br.com.cadastro.model.Categoria;
import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.CategoriaCollectionRepository;
import com.sun.source.doctree.SystemPropertyTree;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Categoria categoria =  new Categoria();
        categoria.setId(1L).setNome("Eletronicos");

        Categoria categoriaSalva = CategoriaCollectionRepository.save(categoria);


        System.out.println("Categoria:" + categoria);



    }
}