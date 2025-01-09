package com.bootcamp.demo.bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;
import java.util.List;


public interface StockSymbolRepository extends JpaRepository<StockEntity,Long> {
  StockEntity findBySymbol(String symbol);
}
