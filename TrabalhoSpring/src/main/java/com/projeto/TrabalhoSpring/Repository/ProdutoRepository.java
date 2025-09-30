package com.projeto.TrabalhoSpring.Repository;

import com.projeto.TrabalhoSpring.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}