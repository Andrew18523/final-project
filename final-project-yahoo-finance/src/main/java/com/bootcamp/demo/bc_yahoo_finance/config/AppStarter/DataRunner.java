package com.bootcamp.demo.bc_yahoo_finance.config.AppStarter;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.redis.RedisHelper;
import com.bootcamp.demo.bc_yahoo_finance.model.Mapper;
import com.bootcamp.demo.bc_yahoo_finance.repository.StockSymbolRepository;
import com.bootcamp.demo.bc_yahoo_finance.service.StockSymbolService;

@Configuration
public class DataRunner implements CommandLineRunner {

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private StockSymbolRepository stockSymbolRepository;
  
  @Override
  public void run(String... args) throws Exception {
    //this.stockSymbolService.deleteAll();
    System.out.println("Server Start...");
    String[] stockList = new String[]{"0388.HK", "0700.HK" , "0005.HK","0770.HK"};
    for (String symbol : stockList) {
      if (stockSymbolRepository.findBySymbol(symbol)== null){
        stockSymbolService.save(mapper.map(symbol));
      }
    }
    // Redis
    redisHelper.set("STOCK-LIST", stockList);
    System.out.println("Server success saving stock symbols...");
  }
}
