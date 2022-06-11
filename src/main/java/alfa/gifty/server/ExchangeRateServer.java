package alfa.gifty.server;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExchangeRateServer {
    int getCurrencyRate(String currencyCode);
}
