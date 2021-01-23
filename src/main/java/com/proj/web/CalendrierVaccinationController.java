package com.proj.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.proj.dao.UserRepository;
import com.proj.dao.VaccinRepository;
import com.proj.dao.EnfantRepository;

import com.proj.entities.CalendrierVaccination;
import com.proj.entities.FicheSuppVitamines;
import com.proj.entities.FicheVaccin;
import com.proj.entities.User;
import com.proj.entities.Vaccin;
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
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VaccinRepository vaccinRepository;
	
	
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
			  
			  String type = fiche.getType_vaccin();
			  Long idcentre = fiche.getCalendrierVaccination().getEnfant().getCentreSante().getId();
			  
			  Vaccin vaccin = vaccinRepository.chercher(idcentre, type);
			  
			  vaccinRepository.edit(vaccin.getQuantiteStock()-1, vaccin.getId());
			  
			  Long i =fiche.getCalendrierVaccination().getEnfant().getId();
			  return "redirect:/operateur/calendrier?id="+i;
		}
		
		return "/403";
		
	}
	
	
	
	@RequestMapping(value="/operateur/rdv")
	public String rdv(Model model , @RequestParam(name = "date", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
        
		List <FicheVaccin> f = ficheVaccinRepository.chercher(date, idcentre);
		model.addAttribute("listRdvVaccin", f);
		
		model.addAttribute("date", date);
		
		return "rdv";
	}
	
	
	@RequestMapping(value="/operateur/rechercheAvancee")
	public String recherchAvancee(Model model 
			, @RequestParam(name = "date", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			, @RequestParam(name = "type", defaultValue = "") String type
			, @RequestParam(name = "sexe", defaultValue = "") String sexe
			,  HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
		
		List <FicheVaccin> f = ficheVaccinRepository.recherchavancee(date, "%"+type+"%", "%"+sexe+"%", idcentre);
		model.addAttribute("list", f);
		
		model.addAttribute("date", date);
		model.addAttribute("type", type);
		model.addAttribute("sexe", sexe);
		
		return "rechercheAvancee";
	}
	
	
	
	@RequestMapping(value="/gestionnaire/tableauxBords/vaccinParMois", method=RequestMethod.GET)
	public String VaccinParMois(Model model, HttpServletRequest request ) throws ParseException {
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date1 = "2020-01-01";
        String date2 = "2020-01-30";
        
        Long idcentre = user.getCentreSnate().getId();
        
		Date debutMois1 = simpleDateFormat.parse(date1);
		Date finMois1 = simpleDateFormat.parse(date2);
		
		List<FicheVaccin> ficheVaccins1 = ficheVaccinRepository.chercherParMois(debutMois1, finMois1, idcentre);
		
		String date3 = "2020-02-01";
        String date4 = "2020-02-28";
        
		Date debutMois2 = simpleDateFormat.parse(date3);
		Date finMois2 = simpleDateFormat.parse(date4);
		List<FicheVaccin> ficheVaccins2 = ficheVaccinRepository.chercherParMois(debutMois2, finMois2, idcentre);
		
		String date5 = "2020-03-01";
        String date6 = "2020-03-30";
        
		Date debutMois3 = simpleDateFormat.parse(date5);
		Date finMois3 = simpleDateFormat.parse(date6);
		List<FicheVaccin> ficheVaccins3 = ficheVaccinRepository.chercherParMois(debutMois3, finMois3, idcentre);
		
		String date7 = "2020-04-01";
        String date8 = "2020-04-30";
        
		Date debutMois4 = simpleDateFormat.parse(date7);
		Date finMois4 = simpleDateFormat.parse(date8);
		List<FicheVaccin> ficheVaccins4 = ficheVaccinRepository.chercherParMois(debutMois4, finMois4, idcentre);
		
		String date9 = "2020-05-01";
        String date10 = "2020-05-30";
        
		Date debutMois5 = simpleDateFormat.parse(date9);
		Date finMois5 = simpleDateFormat.parse(date10);
		List<FicheVaccin> ficheVaccins5 = ficheVaccinRepository.chercherParMois(debutMois5, finMois5, idcentre);
		
		String date11 = "2020-06-01";
        String date12 = "2020-06-30";
        
		Date debutMois6 = simpleDateFormat.parse(date11);
		Date finMois6 = simpleDateFormat.parse(date12);
		List<FicheVaccin> ficheVaccins6 = ficheVaccinRepository.chercherParMois(debutMois6, finMois6, idcentre);
		
		String date13 = "2020-07-01";
        String date14 = "2020-07-30";
        
		Date debutMois7 = simpleDateFormat.parse(date13);
		Date finMois7 = simpleDateFormat.parse(date14);
		List<FicheVaccin> ficheVaccins7 = ficheVaccinRepository.chercherParMois(debutMois7, finMois7, idcentre);
		
		String date15 = "2020-08-01";
        String date16 = "2020-08-30";
        
		Date debutMois8 = simpleDateFormat.parse(date15);
		Date finMois8 = simpleDateFormat.parse(date16);
		List<FicheVaccin> ficheVaccins8 = ficheVaccinRepository.chercherParMois(debutMois8, finMois8, idcentre);
		
		String date17 = "2020-09-01";
        String date18 = "2020-09-30";
        
		Date debutMois9 = simpleDateFormat.parse(date17);
		Date finMois9 = simpleDateFormat.parse(date18);
		List<FicheVaccin> ficheVaccins9 = ficheVaccinRepository.chercherParMois(debutMois9, finMois9, idcentre);
		
		String date19 = "2020-10-01";
        String date20 = "2020-10-30";
        
		Date debutMois10 = simpleDateFormat.parse(date19);
		Date finMois10 = simpleDateFormat.parse(date20);
		List<FicheVaccin> ficheVaccins10 = ficheVaccinRepository.chercherParMois(debutMois10, finMois10, idcentre);
		
		String date21 = "2020-11-01";
        String date22 = "2020-11-30";
        
		Date debutMois11 = simpleDateFormat.parse(date21);
		Date finMois11 = simpleDateFormat.parse(date22);
		List<FicheVaccin> ficheVaccins11 = ficheVaccinRepository.chercherParMois(debutMois11, finMois11, idcentre);
		
		String date23 = "2020-12-01";
        String date24 = "2020-12-30";
        
		Date debutMois12 = simpleDateFormat.parse(date23);
		Date finMois12 = simpleDateFormat.parse(date24);
		List<FicheVaccin> ficheVaccins12 = ficheVaccinRepository.chercherParMois(debutMois12, finMois12, idcentre);
		
		Map<String, Integer> nbrEnfantVaccineParMois = new LinkedHashMap<>();
		
		int nombreParMois =  ficheVaccins1.size();
		nbrEnfantVaccineParMois.put("Janvier", nombreParMois);
		
		nombreParMois = ficheVaccins2.size();
		nbrEnfantVaccineParMois.put("Fevrier", nombreParMois);
		
		nombreParMois = ficheVaccins3.size();
		nbrEnfantVaccineParMois.put("Mars", nombreParMois);
		
		nombreParMois = ficheVaccins4.size();
		nbrEnfantVaccineParMois.put("Avril", nombreParMois);
		
		nombreParMois = ficheVaccins5.size();
		nbrEnfantVaccineParMois.put("Mai", nombreParMois);
		
		nombreParMois = ficheVaccins6.size();
		nbrEnfantVaccineParMois.put("Juin", nombreParMois);
		
		nombreParMois = ficheVaccins7.size();
		nbrEnfantVaccineParMois.put("Juillet", nombreParMois);
		
		nombreParMois = ficheVaccins8.size();
		nbrEnfantVaccineParMois.put("Aout", nombreParMois);
		
		nombreParMois = ficheVaccins9.size();
		nbrEnfantVaccineParMois.put("Septembre", nombreParMois);
		
		nombreParMois = ficheVaccins10.size();
		nbrEnfantVaccineParMois.put("Octobre", nombreParMois);
		
		nombreParMois = ficheVaccins11.size();
		nbrEnfantVaccineParMois.put("Novembre", nombreParMois);
		
		nombreParMois = ficheVaccins12.size();
		nbrEnfantVaccineParMois.put("Décembre", nombreParMois);
		
		model.addAttribute("nbrEnfantVaccineParMois", nbrEnfantVaccineParMois);
		
		return "GraphNbrVaccineMois";
	}
	
	@RequestMapping(value="/gestionnaire/tableauxBords/vaccinParType", method=RequestMethod.GET)
	public String rechercheParType(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
        
        List<FicheVaccin> listeVaccinType1 = ficheVaccinRepository.recherchavanceeParTypeV("Vaccin contre Hépatitie B", idcentre);
        List<FicheVaccin> listeVaccinType2 = ficheVaccinRepository.recherchavanceeParTypeV("Vaccin anti BCG", idcentre);
        List<FicheVaccin> listeVaccinType3 = ficheVaccinRepository.recherchavanceeParTypeV("Vaccin anti Polio oral", idcentre);
        
        model.addAttribute("Vaccin_contre_Hepatitie_B", listeVaccinType1.size());
        model.addAttribute("Vaccin_anti_BCG", listeVaccinType2.size());
        model.addAttribute("Vaccin_anti_Polio_oral", listeVaccinType3.size());
        
		return "GraphVaccinParType";
	}
	
	@RequestMapping(value="/gestionnaire/tableauxBords/vaccinParSexe", method=RequestMethod.GET)
	public String rechercheParSexe(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
        User user = userRepository.chercher(principal.getName());
        
        Long idcentre = user.getCentreSnate().getId();
        
        List<FicheVaccin> listeVaccinGarcon = ficheVaccinRepository.recherchavanceeParSexe("M", idcentre);
        List<FicheVaccin> listeVaccinfille = ficheVaccinRepository.recherchavanceeParSexe("F", idcentre);
        
        
        model.addAttribute("nbrGarconsVaccine", listeVaccinGarcon.size());
        model.addAttribute("nbrFillesVaccine", listeVaccinfille.size());
        
        
		return "GraphVaccinParSexe";
	}
	
	
}
	

