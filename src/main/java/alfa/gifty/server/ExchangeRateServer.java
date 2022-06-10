package alfa.gifty.server;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExchangeRateServer {
    
    List<String> getCharCodes();
    int getCurrencyCode(String currencyCode);
}
