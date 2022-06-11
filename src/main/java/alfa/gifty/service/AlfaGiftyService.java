package alfa.gifty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AlfaGiftyService {

    private ExchangeRateService exchangeRateService;
    private GiphyService giphyService;
    @Value("${giphy.broke}")
    String brokeTag;
    @Value("${giphy.rich}")
    String richTag;
    @Value("${giphy.equal}")
    String equalTag;
    @Value("${giphy.error}")
    String errorTag;

    @Autowired
    public AlfaGiftyService(
            ExchangeRateService exchangeRateService,
            GiphyService giphyService
            ) {
        this.exchangeRateService = exchangeRateService;
        this.giphyService = giphyService;
    }

    public String chooseGif(String code) {
        int gifKey = -101;
        String gifTag = this.errorTag;
        if (code != null) {
            gifKey = exchangeRateService.getCurrencyRate(code);
        }
            switch (gifKey) {
                case 1:
                    gifTag this.richTag;
                    break;
                case -1:
                    gifTag = this.brokeTag;
                    break;
                case 0:
                    gifTag = this.equalTag;
                    break;
            }
        return gifTag;
    }

    ResponseEntity<Map> result()
}
