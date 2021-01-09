package com.proj.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proj.entities.Enfant;

public interface EnfantRepository extends JpaRepository<Enfant, Long>{

	@Query("select e from Enfant e where e.cin_tuteur like :x and e.naissance like :y")
	public List<Enfant> chercher(@Param("x")String cin, @Param("y")Date date);
	
	
	
	@Modifying
	@Query("UPDATE Enfant e SET e.adresse = :x, e.tele_tuteur = :y WHERE e.id = :z")
	
	@Transactional
	public void edit(@Param("x")String adresse, @Param("y")int tele, @Param("z") Long id);
}

