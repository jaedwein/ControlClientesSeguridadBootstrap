package org.darkman.dao;

import org.darkman.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}
