package org.darkman.service;

import java.util.List;

import org.darkman.domain.Persona;

public interface PersonaService {

	  public List<Persona> list();
	  
	  public void save(Persona persona);
	  
	  public void delete (Persona persona);
	  
	  public Persona find(Persona persona);
	 
}
