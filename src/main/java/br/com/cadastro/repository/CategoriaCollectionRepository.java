package br.com.cadastro.repository;

import br.com.cadastro.model.Categoria;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepository {

   private static List<Categoria> categorias;

    static {

        categorias = new Vector<>();

        Categoria eletronicos = new Categoria("Eletronicos");
        Categoria celulares = new Categoria("Celulares");
        Categoria livros = new Categoria("Livros");

        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);

    }

    public static List<Categoria>findAll(){
        return categorias;
    }

    public static Categoria findById(Long id){
        return categorias.stream()
                .filter(c-> c.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public static List<Categoria> findByNome(String nome){

        return categorias.stream()
                .filter(c-> c.getNome().equalsIgnoreCase(nome))
                .toList();
    }

    public static Categoria save(Categoria categoria) {
        if (!categorias.contains(categoria)) {
            categoria.setId((long) categorias.size() + 1);
            categorias.add(categoria);
            return categoria;
        } else {
            return null;
        }
    }


}
