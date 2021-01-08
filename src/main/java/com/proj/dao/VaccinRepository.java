package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.Vaccin;

public interface VaccinRepository extends JpaRepository<Vaccin, Long>{

}

