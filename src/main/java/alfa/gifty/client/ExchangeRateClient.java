package alfa.gifty.client;

import alfa.gifty.model.ExchangeRate;

public interface ExchangeRateClient {

    ExchangeRate getTodayRate(String id);
    ExchangeRate getYesterdayRate(String id, String date);
}
