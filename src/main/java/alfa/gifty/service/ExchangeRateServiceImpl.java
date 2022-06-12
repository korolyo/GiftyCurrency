package alfa.gifty.service;

import alfa.gifty.client.ExchangeRateClient;
import alfa.gifty.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private ExchangeRate todayRate;
    private ExchangeRate yesterdayRate;
    private ExchangeRateClient exchangeRateClient;
    private SimpleDateFormat dateFormat;
    @Value("${openexchangerates.app_id}")
    private String appId;

    @Autowired
    public ExchangeRateServiceImpl(
            ExchangeRateClient exchangeRateClient,
            @Qualifier("date_bean")SimpleDateFormat dateFormat
            ) {
        this.exchangeRateClient = exchangeRateClient;
        this.dateFormat = dateFormat;
    }

    @Override
    public int getCurrencyRate(String currencyBase) {
        this.realRates();
        Double prevCoefficient = this.getSubtractionOfRates(this.yesterdayRate, currencyBase);
        Double currentCoefficient = this.getSubtractionOfRates(this.todayRate, currencyBase);
        return prevCoefficient != null && currentCoefficient != null
                ? Double.compare(currentCoefficient, prevCoefficient)
                : -101;
    }

    private void realRates() {
        long currentTime = System.currentTimeMillis();
        Calendar prevCalendar = Calendar.getInstance();
        prevCalendar.setTimeInMillis(currentTime);
        prevCalendar.add(Calendar.DAY_OF_YEAR, -1);
        String newPrevDate = dateFormat.format(prevCalendar.getTime());

        this.todayRate = exchangeRateClient.getTodayRate(this.appId);
        this.yesterdayRate = exchangeRateClient.getYesterdayRate(this.appId, newPrevDate);
    }

    private Double getSubtractionOfRates(ExchangeRate rate, String currencyBase) {
        Double targetRate = null;
        Map<String, Double> map = null;

        if (rate != null && rate.getRates() != null) {
            map = rate.getRates();
            targetRate = map.get(currencyBase);
        }
        return targetRate;
    }
}
