package com.bootcamp.demo.bc_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StockPriceService {
  List<StockPriceEntity> save(List<String> symbol) throws JsonMappingException, JsonProcessingException;

  List<StockPriceEntity> getStockPrice(String symbol);

  Long maxMarketUnixTime (String symbol);

  // String getRegularMarketTime (String symbol);

  // List<StockPrice> getStockPriceBySymbolAndApiDate(String symbol);
}
