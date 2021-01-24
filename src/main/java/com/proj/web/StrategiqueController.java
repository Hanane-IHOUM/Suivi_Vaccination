package com.proj.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.dao.FicheSuppVitaminesRepository;
import com.proj.dao.FicheVaccinRepository;
import com.proj.dao.UserRepository;
import com.proj.dao.VaccinRepository;
import com.proj.dao.EnfantRepository;

import com.proj.entities.FicheVaccin;
import com.proj.entities.User;
import com.proj.entities.Vaccin;
import com.proj.entities.Enfant;


@Controller
public class StrategiqueController {
	
	@Autowired
	private FicheVaccinRepository ficheVaccinRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VaccinRepository vaccinRepository;
	
	
	@RequestMapping(value="/decideur/tableauxBords/vaccinParAn", method=RequestMethod.GET)
	public String VaccinParAn(Model model) throws ParseException {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        
		
		String date3 = "2020-01-01";
        String date4 = "2020-12-30";
        
		Date debutAn2020 = simpleDateFormat.parse(date3);
		Date finAn2020 = simpleDateFormat.parse(date4);
		
		List<FicheVaccin> ficheVaccins2 = ficheVaccinRepository.chercherParAn(debutAn2020, finAn2020);
		
		String date5 = "2021-01-01";
        String date6 = "2021-12-30";
        
		Date debutAn2021 = simpleDateFormat.parse(date5);
		Date finAn2021 = simpleDateFormat.parse(date6);
		List<FicheVaccin> ficheVaccins3 = ficheVaccinRepository.chercherParAn(debutAn2021, finAn2021);
		
		
		Map<String, Integer> nbrEnfantVaccineParAn = new LinkedHashMap<>();
		
		int nombreParAn =  ficheVaccins2.size();
		nbrEnfantVaccineParAn.put("2020", nombreParAn);
		
		nombreParAn = ficheVaccins3.size();
		nbrEnfantVaccineParAn.put("2021", nombreParAn);
		
		
		model.addAttribute("nbrEnfantVaccineParAn", nbrEnfantVaccineParAn);
		
		return "GraphNbrVaccineAn";
	}
	
	
	@RequestMapping(value="/decideur/tableauxBords/vaccinParSexe", method=RequestMethod.GET)
	public String rechercheParSexedecideur(Model model) {
		
        List<FicheVaccin> listeVaccinGarcon = ficheVaccinRepository.recherchParSexe("M");
        List<FicheVaccin> listeVaccinfille = ficheVaccinRepository.recherchParSexe("F");
        
        
        model.addAttribute("nbrGarconsVaccine", listeVaccinGarcon.size());
        model.addAttribute("nbrFillesVaccine", listeVaccinfille.size());
        
        
		return "GraphVaccinParSexeDecideur";
	}
	
	@RequestMapping(value="/decideur/tableauxBords/vaccinParCentre", method=RequestMethod.GET)
	public String rechercheParCentre(Model model) {
		
        List<FicheVaccin> listeVaccinAgadir = ficheVaccinRepository.recherchParCentre("Centre Agadir");
        List<FicheVaccin> listeVaccinRabat = ficheVaccinRepository.recherchParCentre("Centre Rabat");
        List<FicheVaccin> listeVaccinSale = ficheVaccinRepository.recherchParCentre("Centre Salé");
        List<FicheVaccin> listeVaccinTiznit = ficheVaccinRepository.recherchParCentre("Centre Tiznit");
        
        model.addAttribute("nbrVaccineAgadir", listeVaccinAgadir.size());
        model.addAttribute("nbrVaccineRabat", listeVaccinRabat.size());
        model.addAttribute("nbrVaccineSale", listeVaccinSale.size());
        model.addAttribute("nbrVaccineTiznit", listeVaccinTiznit.size());
        
		return "GraphVaccinParCentre";
	}
	
	@RequestMapping(value="/decideur/tableauxBords/vaccinParRegion", method=RequestMethod.GET)
	public String rechercheParRegion(Model model) {
		
        List<FicheVaccin> listeVaccinSouss = ficheVaccinRepository.recherchParRegion("Souss Massa");
        List<FicheVaccin> listeVaccinRabatSale = ficheVaccinRepository.recherchParRegion("Rabat_Sale");
        
        
        model.addAttribute("nbrVaccineSouss", listeVaccinSouss.size());
        model.addAttribute("nbrVaccineRabatSale", listeVaccinRabatSale.size());
        
        
		return "GraphVaccinParRegion";
	}
}


	

