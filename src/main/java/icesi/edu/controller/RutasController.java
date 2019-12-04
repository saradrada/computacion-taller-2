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

import icesi.edu.exceptions.FechaInvalidaException;
import icesi.edu.exceptions.FechaNullException;
import icesi.edu.exceptions.FechasNoConsistentesException;
import icesi.edu.exceptions.HoraInvalidaException;
import icesi.edu.exceptions.HoraNullException;
import icesi.edu.exceptions.HorasNoConsistentesException;
import icesi.edu.exceptions.RutaNullException;
import icesi.edu.model.Tmio1Bus;
import icesi.edu.model.Tmio1Conductore;
import icesi.edu.model.Tmio1Ruta;
import icesi.edu.services.RutaService;

@Controller
public class RutasController {

	private RutaService service; 
	
	@Autowired
	public RutasController(RutaService service) {
		this.service= service;
	}
	

	@RequestMapping(value = "/rutas", method = RequestMethod.GET)
	public String rutas(Model model) {
		model.addAttribute("rutas", service.findAll() );
		return "rutas/index";
	}
	
	@GetMapping("/rutas/add-ruta")
	public String rutasAdd(Model model) {		
		model.addAttribute("tmio1Ruta", new Tmio1Ruta());
		return "rutas/add";
	}
	
	@PostMapping("/rutas/add-ruta")
	public String saveApps(@RequestParam(value = "action", required = true) String action, @Validated Tmio1Ruta tmio1Ruta,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "rutas/add";
			} else {
				try {
					service.save(tmio1Ruta);
				} catch (RutaNullException | FechasNoConsistentesException | HorasNoConsistentesException
						| FechaNullException | HoraNullException | FechaInvalidaException | HoraInvalidaException e) {
					return "redirect:/error";
				}
			}	
		}
		return "redirect:/rutas";
	}

	@GetMapping("/rutas/consult-ruta")
	public String consultForm(Model model) {

		model.addAttribute("tmio1Ruta", new Tmio1Ruta());
		return "rutas/consult";
	}
	
	@PostMapping("/rutas/consult-ruta")
	public String showConsultForm2(@ModelAttribute Tmio1Ruta tmio1Ruta, Model model) {

		Optional<Tmio1Ruta> r = service.findById(tmio1Ruta.getId());
		if (r.get() == null) {
			
		}
		
		model.addAttribute("tmio1Ruta", r.get());
		return "rutas/edit";
	}
	
	
	
}

