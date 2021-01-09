package com.proj.web;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.dao.CalendrierVaccinationRepository;
import com.proj.dao.FicheSuppVitaminesRepository;
import com.proj.dao.FicheVaccinRepository;
import com.proj.dao.EnfantRepository;

import com.proj.entities.CalendrierVaccination;
import com.proj.entities.FicheSuppVitamines;
import com.proj.entities.FicheVaccin;
import com.proj.entities.Enfant;


@Controller
public class CalendrierVaccinationController {
	
	
	//@Autowired
	//private CalendrierVaccinationRepository calendrierVaccinationRepository;
	
	@Autowired
	private FicheSuppVitaminesRepository ficheSuppVitaminesRepository;
	
	@Autowired
	private FicheVaccinRepository ficheVaccinRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	
	@RequestMapping(value="/operateur/calendrier")
	public String details(Model model ,@RequestParam() Long id) {
		
		Optional<Enfant> e = enfantRepository.findById(id);
		
		if(e.isPresent()) {
			  Enfant enfant = e.get();
			  model.addAttribute("enfant", enfant);
			  model.addAttribute("ficheVaccin" , enfant.getCalendrierVaccination().getFicheVaccins());
			  model.addAttribute("ficheSupp" , enfant.getCalendrierVaccination().getFicheSuppVitamines());
		}
		
		return "details";
	}
	
	
	@RequestMapping(value="/operateur/editfichevaccine", method=RequestMethod.GET)
	public String editfichevaccin(Model model, @RequestParam()Long id) {
		
		Optional<FicheVaccin> f = ficheVaccinRepository.findById(id);
		
		if(f.isPresent()) {
			  FicheVaccin fiche = f.get();
			  Long idd= fiche.getId();
			  ficheVaccinRepository.edit(true, idd);
			  Long i =fiche.getCalendrierVaccination().getEnfant().getId();
			  return "redirect:/operateur/calendrier?id="+i;
		}
		
		return "/403";
		
	}
	
	
	/*
	
	@RequestMapping(value="/operateur/editfichevaccin", method=RequestMethod.GET)
	public String editfichesupp(Model model, Long id) {
		Optional<FicheSuppVitamines> f = ficheSuppVitaminesRepository.findById(id);
		
		if(f.isPresent()) {
			  FicheSuppVitamines fiche = f.get();
			  fiche.setEtat(true);
		}
		
		return "redirect:/details";
	}
	*/
	
	@RequestMapping(value="/operateur/rdv")
	public String rdv(Model model , @RequestParam(name = "date", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		
		List <FicheVaccin> f = ficheVaccinRepository.chercher(date);
		model.addAttribute("listRdvVaccin", f);
		
		
		//List <FicheSuppVitamines> fs = ficheSuppVitaminesRepository.chercher(date);
		//model.addAttribute("listRdvSupp", fs);
		
		model.addAttribute("date", date);
		
		return "rdv";
	}
	
}
