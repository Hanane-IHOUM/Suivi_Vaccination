package com.proj.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entities.FicheSuppVitamines;

public interface FicheSuppVitaminesRepository extends JpaRepository<FicheSuppVitamines, Long>{
	
	@Query("select f from FicheSuppVitamines f where f.date like :x ")
	public List<FicheSuppVitamines> chercher(@Param("x")Date date);

}

