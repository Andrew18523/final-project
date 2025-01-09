package com.bootcamp.demo.bc_yahoo_finance.service;

import java.time.LocalDate;
import java.util.List;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.SystemDateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GetSystemDateService {

  LocalDate getSystemDate(String symbol) throws JsonProcessingException;
}
