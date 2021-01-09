package com.proj.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proj.entities.FicheVaccin;

public interface FicheVaccinRepository extends JpaRepository<FicheVaccin, Long>{
	
	@Modifying
	@Query("UPDATE FicheVaccin f SET f.etat = :x WHERE f.id = :y")
	
	@Transactional
	public void edit(@Param("x")boolean etat, @Param("y") Long id);
	
	
	@Query("select f from FicheVaccin f where f.date like :x and f.etat like false")
	public List<FicheVaccin> chercher(@Param("x")Date date);
}


