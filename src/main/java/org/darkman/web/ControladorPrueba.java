package org.darkman.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorPrueba {

	@GetMapping("/entidad/")
		public String getEntidad() {
			log.info("/entidad/");
			return "redirect:/";
	}
	
}
