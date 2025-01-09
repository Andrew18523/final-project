package com.bootcamp.demo.bc_yahoo_finance.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoofinance.YHRestClient;
import com.bootcamp.demo.bc_yahoo_finance.model.Mapper;
import com.bootcamp.demo.bc_yahoo_finance.model.TranType;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import com.bootcamp.demo.bc_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.demo.bc_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo.bc_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class StockPriceImpl implements StockPriceService {

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private Mapper mapper;

  @Override
  public List<StockPriceEntity> save(List<String> symbol)
    throws JsonMappingException, JsonProcessingException {
    YahooQuoteDTO yahooQuoteDTO = new YHRestClient(restTemplate)
      .getQuote(symbol);
    List<YahooQuoteDTO.QuoteBody.Result> result =
        yahooQuoteDTO.getBody().getResult();

    List<StockEntity> stockEntitys = stockSymbolService.findAll();
    List<StockPriceEntity> stockPrices = result.stream()//
        .map(stock -> {
          StockPriceEntity stockPrice = this.mapper.map(stock);
          stockPrice.setType(TranType.FIVE_MINUTES.getType());

          stockEntitys.forEach(stockEntity -> {
            if (stockEntity.getSymbol().equals(stockPrice.getSymbol())) {
              stockPrice.setStock(stockEntity);
            }
          });
          return stockPrice;
        })//
        .collect(Collectors.toList());


    stockPriceRepository.saveAll(stockPrices);

    return stockPrices;
  }

  @Override
  public List<StockPriceEntity> getStockPrice(String symbol){
    return stockPriceRepository.findBySymbol(symbol);
  }
  
  @Override
  public Long maxMarketUnixTime (String symbol){
    Long maxMarketUnixTime = stockPriceRepository.findBySymbol(symbol).stream()
    .map(StockPriceEntity::getRegularMarketTime)
    .max(Long::compareTo)
    .orElseThrow();
    System.out.println(maxMarketUnixTime);
    return maxMarketUnixTime;
  }

  // @Override
  // public String getRegularMarketTime (String symbol){
  //   List<StockPrice> stockPrices = stockPriceRepository.findBySymbol(symbol);
  //   Long maxMarketUnixTime = stockPrices.stream()
  //   .map(StockPrice::getMarketUnixTime)
  //   .max(Long::compareTo)
  //   .orElseThrow();
  //   if (maxMarketUnixTime.equals(0)){
  //     return "";
  //   }
  //   String apiDateTime = stockPrices.stream()
  //   .filter(stockPrice -> stockPrice.getMarketUnixTime().equals(maxMarketUnixTime))
  //   .map(StockPrice::getApiDateTime)
  //   .findFirst()
  //   .orElse("").substring(0, 10);

  //   return apiDateTime;
  // }

  // @Override
  // public List<StockPrice> getStockPriceBySymbolAndApiDate(String symbol) {
  //   List<StockPrice> stockPrices = stockPriceRepository.findBySymbol(symbol);
  //   Long maxMarketUnixTime = stockPrices.stream()
  //   .map(StockPrice::getMarketUnixTime)
  //   .max(Long::compareTo)
  //   .orElseThrow();

  //   String apiDateTime = stockPrices.stream()
  //   .filter(stockPrice -> stockPrice.getMarketUnixTime().equals(maxMarketUnixTime))
  //   .map(StockPrice::getApiDateTime)
  //   .findFirst()
  //   .orElse("").substring(0, 10);

  //   return stockPriceRepository.findBySymbolAndApiDateTime(symbol,apiDateTime);
  // }


}
