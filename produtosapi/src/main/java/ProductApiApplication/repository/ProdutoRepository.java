package ProductApiApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductApiApplication.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
