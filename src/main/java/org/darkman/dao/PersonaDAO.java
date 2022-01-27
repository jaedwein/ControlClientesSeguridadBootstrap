package org.darkman.dao;

import org.darkman.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDAO extends JpaRepository<Persona, Long>{
	

}
