package com.proj.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
}


