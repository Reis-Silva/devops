package com.infnet.projeto.devops.dao;

import com.infnet.projeto.devops.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
}
