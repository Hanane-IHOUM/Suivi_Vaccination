package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.FicheVaccin;

public interface FicheVaccinRepository extends JpaRepository<FicheVaccin, Long>{
}

