package egd.covid.covidfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.covidfront.service.SearchService;
import lombok.Getter;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

	BusquedaDto busquedaDto;
	
	@Getter
	private boolean submitDisabled = true;

	@Autowired
	SearchService searchService;

	@GetMapping
	public String mainx(Model model) {
		model.addAttribute("busquedaDto", new BusquedaDto());
		return "index";
	}

	@PostMapping("/find")
	public RedirectView createUser(BusquedaDto busquedaDto, RedirectAttributes redirectAttributes) {
		//log.info("{}", busquedaDto.toString());
		List<PersonaDto> personas = searchService.search(busquedaDto);
		redirectAttributes.addFlashAttribute("personas", personas);
		redirectAttributes.addFlashAttribute("busquedaDto", busquedaDto);
		return new RedirectView("/", true);
	}
}

