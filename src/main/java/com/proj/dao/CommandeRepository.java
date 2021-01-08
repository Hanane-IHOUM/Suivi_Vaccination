package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}

