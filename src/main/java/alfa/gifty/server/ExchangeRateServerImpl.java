package alfa.gifty.server;

import alfa.gifty.client.ExchangeRateClient;
import alfa.gifty.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeRateServerImpl implements ExchangeRateServer {
//
    private ExchangeRate todayRate;
    private ExchangeRate yesterdayRate;
    private ExchangeRateClient exchangeRateClient;
//    private SimpleDateFormat dateFormat;
//    private SimpleDateFormat timeFormat;
//    private Double
    @Value("${openexchangerates.app_id}")
    private String appId;
    @Value("${openexchangerates.currency}")
    private String currencyBase;
//
    @Autowired
    public ExchangeRateServerImpl(
            ExchangeRateClient exchangeRateClient
    ) {
        this.exchangeRateClient = exchangeRateClient;
    }

    @Override
    public int getCurrencyRate(String currencyBase) {
        Double prevCoefficient = this.getSubtractionOfRates(this.yesterdayRate);
        Double currentCoefficient = this.getSubtractionOfRates(this.todayRate);
        return prevCoefficient != null && currentCoefficient != null
                ? Double.compare(currentCoefficient, prevCoefficient)
                : -101;
    }

    private Double getSubtractionOfRates(ExchangeRate rate) {
        Double targetRate = null;
        Map<String, Double> map = null;
        if (rate != null && rate.getRates() != null) {
            map = rate.getRates();
            targetRate = map.get(this.currencyBase);
        }
        return targetRate;
    }

//    private Double getCoefficient(ExchangeRate rate, String currencyCode) {
//        Double result = null;
//        Double targetRate = null;
//        Double appBaseRate = null;
//        Double defaultBaseRate = null;
//        Map<String, Double> map = null;
//        if (rate != null && rate.getRates() != null) {
//            map = rate.getRates();
//            targetRate = map.get(currencyCode);
//            appBaseRate = map.get(this.currency);
//            defaultBaseRate = map.get(rate.getBase());
//        }
//        if (targetRate != null && appBaseRate != null && defaultBaseRate != null) {
//            result = new BigDecimal(
//                    (defaultBaseRate / appBaseRate) * targetRate
//            )
//                    .setScale(4, RoundingMode.UP)
//                    .doubleValue();
//        }
//        return result;
//    }
}
