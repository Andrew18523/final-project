package com.bootcamp.demo.bc_yahoo_finance.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="tstocks_price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonPropertyOrder({"stock_id", "symbol", "regularMarketTime",
    "regularMarketPrice", //
    "regularMarketChangePercent", "bid", "bidSize", "ask", "askSize", "type",
    "apiDateTime", "marketUnixTime", "stock"})
public class StockPriceEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("stock_id")
  private Long id;

  private String symbol;

  private Long regularMarketTime;

  private String regularMarketPrice;

  private String regularMarketChangePercent;

  private String bid;

  private String bidSize;

  private String ask;

  private String askSize;

  private String type;
  // 5M = 5 mins , D =Daily , W = weekly , M = Monthly

  private LocalDateTime apiDateTime;

  @ManyToOne
  @JoinColumn(name = "stock_id")
  private StockEntity stock;
}
