package com.bootcamp.demo.bc_yahoo_finance.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.YahooQuoteDTO;

@Component
public class Mapper {
  
  public StockEntity map (String stock){
    return StockEntity.builder()
      .symbol(stock)
      .build();
  }

    public StockPriceEntity map(YahooQuoteDTO.QuoteBody.Result result) {
    return StockPriceEntity.builder()//
        .symbol(result.getSymbol())//
        .regularMarketTime(result.getRegularMarketTime().longValue())//
        .regularMarketPrice(String.valueOf(result.getRegularMarketPrice()))//
        .regularMarketChangePercent(String.valueOf(result.getRegularMarketChangePercent()))//
        .bid(String.valueOf(result.getBid()))//
        .bidSize(String.valueOf(result.getBidSize()))//
        .ask(String.valueOf(result.getAsk()))//
        .askSize(String.valueOf(result.getAskSize()))//
        // .apiDateTime(LocalDateTime.now(ZoneId.of("CTT")).toString())
        .apiDateTime(LocalDateTime.now())//
        .type(null)//
        .build();
  }

  public LocalDateTime stringToLocalDateTime (String stringTime){

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

    LocalDateTime localDateTime = LocalDateTime.parse(stringTime, formatter);

    return localDateTime;
  }
}
