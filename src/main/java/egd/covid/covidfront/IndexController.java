package egd.covid.covidfront;

import egd.covid.covidfront.entity.BusquedaDto;
import egd.covid.covidfront.entity.Rating;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    BusquedaDto busquedaDto;

    @GetMapping
    public String mainx(Model model) {
        model.addAttribute("busquedaDto", new BusquedaDto());
        return "index";
    }

    @RequestMapping("/find")
    public ModelAndView createUser(BusquedaDto busquedaDto, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        RedirectView redirectView = new RedirectView("index");
        redirectView.setContextRelative(true);
        modelAndView.setView(redirectView);
        return modelAndView;
    }
}
