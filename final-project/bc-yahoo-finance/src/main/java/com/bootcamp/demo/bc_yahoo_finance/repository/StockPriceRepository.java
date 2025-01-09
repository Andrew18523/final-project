package com.bootcamp.demo.bc_yahoo_finance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;

public interface StockPriceRepository extends JpaRepository<StockPriceEntity,Long> {


  List<StockPriceEntity> findBySymbol(String symbol);

  // @Query("SELECT sp FROM StockPrice sp WHERE sp.symbol = :symbol AND sp.apiDateTime LIKE CONCAT('%', :x, '%')")
  // List<StockPrice> findBySymbolAndApiDateTime(@Param("symbol") String symbol, @Param("x") String x);

  @Query(
    value = "SELECT max(p.regularMarketTime) FROM StockPriceEntity p WHERE p.symbol = :symbol")
  Long getMaxRegularMarketTime(@Param("symbol") String symbol);
}
