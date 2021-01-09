package com.proj.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proj.entities.Vaccin;

public interface VaccinRepository extends JpaRepository<Vaccin, Long>{
	
	@Query("select v from Vaccin v"
			+ " inner join Stock s on v.stock = s.id"
			+ " inner join CentreSante cs on s.centreSante.id = cs.id"
			+ " where cs.id like :x"
			+ " and v.type_vaccin like :y")
	public Vaccin chercher(@Param("x")Long idcentre, @Param("y")String type_vaccin);
	
	
	
	@Query("select v from Vaccin v"
			+ " inner join Stock s on v.stock = s.id"
			+ " where s.centreSante.id like :x")
	public List<Vaccin> chercherstock(@Param("x")Long idcentre);
	
	
	
	@Modifying
	@Query("UPDATE Vaccin v SET v.quantiteStock = :x WHERE v.id = :y")
	@Transactional
	public void edit(@Param("x")int quantite, @Param("y") Long id);

}

