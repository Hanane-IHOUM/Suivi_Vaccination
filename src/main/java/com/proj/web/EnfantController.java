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

import com.proj.dao.EnfantRepository;
import com.proj.entities.Enfant;

import com.proj.dao.CalendrierVaccinationRepository;
import com.proj.entities.CalendrierVaccination;
import com.proj.entities.CentreSante;
import com.proj.dao.FicheVaccinRepository;
import com.proj.dao.UserRepository;
import com.proj.entities.FicheVaccin;
import com.proj.entities.User;

@Controller
public class EnfantController {
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
	private CalendrierVaccinationRepository calendrierVaccinationRepository;
	
	@Autowired
	private FicheVaccinRepository ficheVaccinRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value="/operateur/enfants")
	public String index(Model model, HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
        
		List <Enfant> enfants = enfantRepository.chercherenfantcentre(idcentre);
		model.addAttribute("listEnfants", enfants);
		return "listeEnfants";
	}
	
	
	@RequestMapping(value="/operateur/recherche")
	public String recherche(Model model ,@RequestParam(name="cin", defaultValue="") String cin, 
						@RequestParam(name = "date", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
						,HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
		
		List <Enfant> enfants = enfantRepository.chercher("%"+cin+"%",date, idcentre);
		
		model.addAttribute("listEnfants", enfants);
		model.addAttribute("cin", cin);
		model.addAttribute("date", date);
		return "enfants";
	}
	
	

	@RequestMapping(value="/operateur/formedit", method=RequestMethod.GET)
	public String formedit(Model model, Long id) {
		Optional<Enfant> e = enfantRepository.findById(id);
		
		if(e.isPresent()) {
			  Enfant enfant = e.get();
			  model.addAttribute("enfant", enfant);
		}
		
		return "editEnfant";
	}
	
	@RequestMapping(value="/operateur/edit", method=RequestMethod.POST)
	public String edit(Model model, Long id, @RequestParam(name = "adresse")String adresse,
						@RequestParam(name = "tele_tuteur")int tele) {
		
		Optional<Enfant> e = enfantRepository.findById(id);
		
		if(e.isPresent()) {
			Enfant enfant = e.get();
			Long idd= enfant.getId();
			enfantRepository.edit(adresse, tele, idd);
		}
		
		
		return "redirect:/operateur/enfants";
	}
	
	@RequestMapping(value="/operateur/form", method=RequestMethod.GET)
	public String formEnfant(Model model) {
		model.addAttribute("enfant", new Enfant());
		return "formEnfant";
	}
	
	@RequestMapping(value="/operateur/save", method=RequestMethod.POST)
	public String save(Model model, @Valid Enfant enfant, 
				@RequestParam(name = "date1", defaultValue = "2020-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, 
				@RequestParam(name = "date2", defaultValue = "2020-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2, 
				@RequestParam(name = "date3", defaultValue = "2020-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date3,
				BindingResult bindingResult, HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			return "formEnfant";
		}
		
		CalendrierVaccination calendrier =  new CalendrierVaccination();
		enfant.setCalendrierVaccination(calendrier);
		
		calendrierVaccinationRepository.save(calendrier );
		
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        CentreSante centre = user.getCentreSnate();
        enfant.setCentreSante(centre);
        
		enfantRepository.save(enfant);
		
		calendrier.setEnfant(enfant);
		calendrierVaccinationRepository.save(calendrier );
		
		
		FicheVaccin f1 = new FicheVaccin("Vaccin contre Hépatitie B", date1, false, calendrier);
		ficheVaccinRepository.save(f1);
		
		FicheVaccin f2 = new FicheVaccin("Vaccin anti BCG", date2 ,false, calendrier);
		ficheVaccinRepository.save(f2);
		
		FicheVaccin f3 = new FicheVaccin("Vaccin anti Polio oral", date3, false, calendrier);
		ficheVaccinRepository.save(f3);
		
		
		
		return "confirmation";
	}
	
	
	
	@RequestMapping(value="/")
	public String home(HttpServletRequest request) {
		
		boolean isOper = request.isUserInRole("OPERATEUR");
		boolean isGest = request.isUserInRole("GESTIONN");
		
		if(isOper) {
			return "redirect:/operateur/enfants";
		}
		else {
			if(isGest){
				return "redirect:/gestionnaire/tableauxBords/vaccinParSexe";
			}
		}
		return "redirect:/decideur/tableauxBords/vaccinParAn";
	}
	
	
	@RequestMapping(value="/403")
	public String accessDneied() {
		return "403";
	}
	
	@RequestMapping(value="login")
	public String login() {
		return "login";
	}

}
