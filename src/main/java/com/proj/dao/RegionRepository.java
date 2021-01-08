package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Long>{
}


