package alfa.gifty.server;

import alfa.gifty.client.ExchangeRateClient;
import alfa.gifty.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRateServerImpl implements ExchangeRateServer {

    private ExchangeRate todayRate;
    private ExchangeRate yesterdayRate;
    private ExchangeRateClient exchangeRateClient;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat timeFormat;
    private Double
    @Value("${openexchangerates.app_id}")
    private String appId;
    @Value("${openexchangerates.currency}")
    private String currency;

    @Autowired
    public ExchangeRateServerImpl(
            ExchangeRateClient exchangeRateClient
    ) {
        this.exchangeRateClient = exchangeRateClient;
    }

    @Override
    public List<String> getCharCodes() {
        List<String> result = null;
        if (this.todayRate.getRates() != null) {
            result = new ArrayList<>(this.todayRate.getRates().keySet());
        }
        return result;
    }

    @Override
    public int getCurrencyCode(String currencyCode) {
        Double prevCoefficient = this.getCoefficient(this.yesterdayRate, currencyCode);
        Double currentCoefficient = this.getCoefficient(this.todayRate, currencyCode);
        return prevCoefficient != null && currentCoefficient != null
                ? Double.compare(currentCoefficient, prevCoefficient)
                : -101;

    }

    private Double getCoefficient(ExchangeRate rate, String currencyCode) {
        Double result = null;
        Double targetRate = null;
        Double appBaseRate = null;
        Double defaultBaseRate = null;
        Map<String, Double> map = null;
        if (rate != null && rate.getRates() != null) {
            map = rate.getRates();
            targetRate = map.get(currencyCode);
            appBaseRate = map.get(this.currency);
            defaultBaseRate = map.get(rate.getBase());
        }
        if (targetRate != null && appBaseRate != null && defaultBaseRate != null) {
            result = new BigDecimal(
                    (defaultBaseRate / appBaseRate) * targetRate
            )
                    .setScale(4, RoundingMode.UP)
                    .doubleValue();
        }
        return result;
    }


}
