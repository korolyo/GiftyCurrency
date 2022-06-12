package alfa.gifty.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
        JsonNode parent = null;
        int gifKey = -101;
        String gifTag = this.errorTag;

        if (code != null) {
            gifKey = exchangeRateService.getCurrencyRate(code);
        }
            switch (gifKey) {
                case 1:
                    gifTag = this.richTag;
                    break;
                case -1:
                    gifTag = this.brokeTag;
                    break;
                case 0:
                    gifTag = this.equalTag;
                    break;
            }

        try {
            parent = new ObjectMapper().readTree(giphyService.getGif(gifTag));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String res = parent.get("data")
                .get("images")
                .get("original")
                .get("url").asText();
        System.out.println(res);
        return res.split("\\?")[0];
    }
}
