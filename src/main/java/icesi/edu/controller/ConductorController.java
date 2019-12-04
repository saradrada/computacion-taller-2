package icesi.edu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.exceptions.ConductorNullException;
import icesi.edu.exceptions.FechaNullException;
import icesi.edu.exceptions.FechasNoConsistentesException;
import icesi.edu.exceptions.FormatoIncorrectoException;
import icesi.edu.model.Tmio1Bus;
import icesi.edu.model.Tmio1Conductore;
import icesi.edu.services.ConductorService;

@Controller
public class ConductorController {

	private ConductorService service;

	@Autowired
	public ConductorController(ConductorService service) {
		this.service = service;
	}

	@RequestMapping(value = "/conductores", method = RequestMethod.GET)
	public String conductores(Model model) {
		model.addAttribute("conductores", service.findAll());
		return "conductores/index";
	}

	@GetMapping("/conductores/add-conductor")
	public String conductoresAdd(Model model) {

		model.addAttribute("tmio1Conductore", new Tmio1Conductore());
		return "conductores/add";
	}

	@PostMapping("/conductores/add-conductor")
	public String saveApps(@RequestParam(value = "action", required = true) String action,@Validated Tmio1Conductore tmio1Conductore,
			BindingResult bindingResult, Model model) {
		
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "conductores/add";
			}
			else {
				try {
					service.save(tmio1Conductore);
				} catch (ConductorNullException | FechasNoConsistentesException | FechaNullException
						| FormatoIncorrectoException e) {
					return "redirect:/error";
				}
			}
		}
		return "redirect:/conductores";
	}

	
	
	@GetMapping("/conductores/consult-conductor")
	public String consultForm(Model model) {

		model.addAttribute("tmio1Conductore", new Tmio1Conductore());
		return "conductores/consult";
	}
	
	
	@PostMapping("/conductores/consult-conductor")
	public String showConsultForm2(@ModelAttribute Tmio1Conductore tmio1Conductore, Model model) {

		Optional<Tmio1Conductore> c = service.findById(tmio1Conductore.getCedula());
		if (c.get() == null) {
			
		}
		
		model.addAttribute("tmio1Conductore", c.get());
		return "conductores/edit";
	}
	
	
}
