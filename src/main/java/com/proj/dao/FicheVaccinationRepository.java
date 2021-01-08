package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.CalendrierVaccination;

public interface FicheVaccinationRepository extends JpaRepository<CalendrierVaccination, Long>{

}

