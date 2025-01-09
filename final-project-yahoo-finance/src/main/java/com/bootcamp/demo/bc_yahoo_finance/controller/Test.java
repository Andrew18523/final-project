package com.bootcamp.demo.bc_yahoo_finance.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoofinance.CookieManager;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.SystemDateDTO;
import com.bootcamp.demo.bc_yahoo_finance.service.GetSystemDateService;
import com.bootcamp.demo.bc_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo.bc_yahoo_finance.service.impl.StockPriceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class Test {
  @Autowired
  private CookieManager cookieManager;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private GetSystemDateService getSystemDateService;

  @GetMapping("/test")
  public String test() {
      return cookieManager.getCookie();
  }
  

  @GetMapping("/stcok/{symbol}")
  public List<StockPriceEntity>  getStockPrice(@PathVariable String symbol){
    return stockPriceService.getStockPrice(symbol);
  }

  @GetMapping("/max/{symbol}")
  public Long  getmaxMarketUnixTime(@PathVariable String symbol){
    return stockPriceService.maxMarketUnixTime(symbol);
  }

  @GetMapping("/systemDate/{symbol}")
  public LocalDate getSystemDate(@PathVariable String symbol)throws JsonProcessingException{
    return getSystemDateService.getSystemDate(symbol);
  }
}
