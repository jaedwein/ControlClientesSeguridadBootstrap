package org.darkman.service;

import java.util.List;

import org.darkman.dao.PersonaDAO;
import org.darkman.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> list() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		personaDAO.save(persona);
	}

	@Override
	@Transactional
	public void delete(Persona persona) {
		personaDAO.delete(persona);

	}

	@Override
	@Transactional(readOnly = true)
	public Persona find(Persona persona) {
		return personaDAO.findById(persona.getId()).orElse(null);
	}

}
