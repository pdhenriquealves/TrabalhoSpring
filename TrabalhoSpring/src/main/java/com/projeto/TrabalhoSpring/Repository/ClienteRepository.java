package com.projeto.TrabalhoSpring.Repository;

import com.projeto.TrabalhoSpring.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}