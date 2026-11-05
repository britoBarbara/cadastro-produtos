package br.com.cadastro.repository;

import br.com.cadastro.model.Categoria;

import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepository {

    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();

        Categoria eletronicos = new Categoria(1L, "Eletronicos");
        Categoria celulares = new Categoria(2L, "Celulares");
        Categoria livros = new Categoria(3L, "Livros");

        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);
    }

    public static List<Categoria> findAll() {
        return categorias;
    }

    public static Categoria findById(Long id) {
        if (id == null) {
            return null;
        }
        return categorias.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Categoria> findByNome(String nome) {
        if (nome == null) {
            return List.of();
        }
        return categorias.stream()
                .filter(c -> c.getNome() != null && c.getNome().equalsIgnoreCase(nome))
                .toList();
    }

    public static Categoria save(Categoria categoria) {
        if (categoria == null || categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            return null;
        }
        if (!categorias.contains(categoria)) {
            categoria.setId((long) categorias.size() + 1);
            categorias.add(categoria);
            return categoria;
        } else {
            return null;
        }
    }
}
