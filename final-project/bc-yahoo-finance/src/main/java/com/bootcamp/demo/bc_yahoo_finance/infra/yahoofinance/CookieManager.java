package com.bootcamp.demo.bc_yahoo_finance.infra.yahoofinance;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.util.Scheme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class CookieManager {

  @Autowired
  private RestTemplate restTemplate;

  public String getCookie(){
    try {
      String cookieUrl = UriComponentsBuilder.newInstance()//
          .scheme(Scheme.HTTPS.name().toLowerCase())//
          .host(YahooFinance.DOMAINE)//
          .toUriString();
      ResponseEntity<String> entity =
          restTemplate.getForEntity(cookieUrl, String.class);
      List<String> cookies = entity.getHeaders().get("Set-Cookie");

      return cookies != null ? cookies.get(0).split(";")[0] : null;
    } catch (RestClientException e) {
      if (e instanceof HttpStatusCodeException) {
        HttpHeaders headers =
            ((HttpStatusCodeException) e).getResponseHeaders();
        if (headers != null) {
          List<String> cookies = headers.get("Set-Cookie");
          return cookies != null ? cookies.get(0).split(";")[0] : null;
        }
      }
    }
    return null;

  }
}
