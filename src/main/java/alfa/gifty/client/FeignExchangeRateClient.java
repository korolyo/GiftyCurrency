package alfa.gifty.client;

import alfa.gifty.model.ExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange", url = "${openexchangerates.url}")
public interface FeignExchangeRateClient extends ExchangeRateClient {

    @Override
    @GetMapping("/latest.json")
    ExchangeRate getTodayRate(@RequestParam("app_id") String id);

    @Override
    @GetMapping("/historical/{date}.json")
    ExchangeRate getYesterdayRate(
                    @RequestParam("app_id") String id,
                    @PathVariable String date
    );
}
