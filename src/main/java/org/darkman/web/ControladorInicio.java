package org.darkman.web;

import javax.validation.Valid;

import org.darkman.domain.Persona;
import org.darkman.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model, @AuthenticationPrincipal User user) {
		var personas = personaService.list();
		log.info("Ejecutando controlador Spring MVC");
		log.info("Usuario logueado: " + user.toString());
		log.debug(model.toString());
		model.addAttribute("personas", personas);
		var saldoTotal = 0D;
        for(var p: personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
		return "index";
	}

	@GetMapping("/add")
	public String add(Persona persona) {
		log.info("get /add");
		return "modificar";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("get /login");
		return "login";
	}
	
	@GetMapping("/errores/403")
	public String noAutorizado() {
		log.info("get /errores/403");
		return "errores/403";
	}

	@PostMapping("/save")
	public String save(@Valid Persona persona, Errors errores) {
		log.info("post /save");
		if(errores.hasErrors()) {
			log.info("Errores de validacion en post /save");
			return "modificar";
		}
		personaService.save(persona);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String update(Persona persona, Model model) {
		log.info("get /update");
		model.addAttribute("persona", personaService.find(persona));
		return "modificar";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Persona persona) {
		log.info("get /delete");
		personaService.delete(persona);
		return "redirect:/";
	}
}
