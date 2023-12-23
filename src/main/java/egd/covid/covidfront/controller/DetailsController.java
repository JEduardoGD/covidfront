package egd.covid.covidfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/details" })
public class DetailsController {

	@GetMapping
	public String mainx(Model model, @RequestParam(name = "idpersona", defaultValue = "0") int idpersona) {
		if (idpersona <= 0) {
			return "details";
		}
		
		
		
		return "details";
	}
}
