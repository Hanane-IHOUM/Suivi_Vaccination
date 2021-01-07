package com.proj.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.dao.EnfantRepository;
import com.proj.entities.Enfant;

@Controller
public class EnfantContoller {
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@RequestMapping(value="/operateur/enfants")
	public String index(Model model , @RequestParam(name="cin", defaultValue="")String cin, @RequestParam(name="date", defaultValue="")Date date) {
		
		List <Enfant> enfants = enfantRepository.chercher(cin, date);
		model.addAttribute("listEnfants", enfants);
		model.addAttribute("cin", cin);
		model.addAttribute("date", date);
		return "enfants";
	}
	
	
	@RequestMapping(value="/operateur/form", method=RequestMethod.GET)
	public String formEnfant(Model model) {
		model.addAttribute("enfant", new Enfant());
		return "formEnfant";
	}
	
	
	@RequestMapping(value="/operateur/edit", method=RequestMethod.GET)
	public String edit(Model model, Long id) {
		Optional<Enfant> e = enfantRepository.findById(id);
		
		if(e.isPresent()) {
			  Enfant enfant = e.get();
			  model.addAttribute("enfant", enfant);
		}
		
		return "editEnfant";
	}
	
	@RequestMapping(value="/operateur/save", method=RequestMethod.POST)
	public String save(Model model, @Valid Enfant enfant, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formEnfant";
		}
		enfantRepository.save(enfant);
		return "confirmation";
	}
	
	
	
	@RequestMapping(value="/")
	public String home() {
		
		return "redirect:/operateur/enfants";
	}
	
	
	@RequestMapping(value="/403")
	public String accessDneied() {
		return "403";
	}
	
	

}
