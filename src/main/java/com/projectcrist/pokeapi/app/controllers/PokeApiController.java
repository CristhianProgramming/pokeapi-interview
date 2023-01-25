package com.projectcrist.pokeapi.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokeApiController {
	
	@GetMapping("/")
	public String listOfPokemons(Model model) {
	model.addAttribute("title","POKEFIND");
		
	return "Pokemon";
	}
	
}
