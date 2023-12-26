package egd.covid.covidfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.covidfront.service.SearchService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping({ "/details" })
@Slf4j
public class DetailsController {

	@Autowired
	SearchService searchService;

	@GetMapping
	public String mainx(Model model, @RequestParam(name = "idpersona", defaultValue = "0") long idpersona) {
		log.info("ID PERSONA: {}", idpersona);
		if (idpersona <= 0) {
			return "details";
		}
		PersonaDto personaDto = searchService.searchByIdPersona(idpersona);
		model.addAttribute("personaDto", personaDto);
		return "details";
	}
}
