package com.bootcamp.demo.bc_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;

public interface StockSymbolService {

  List<StockEntity> findAll();
  
  List<StockEntity> saveAll(List<StockEntity> symbolsList);

  StockEntity save (StockEntity symbol);

  void deleteAll();
}
