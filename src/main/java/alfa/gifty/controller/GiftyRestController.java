package alfa.gifty.controller;

import alfa.gifty.service.AlfaGiftyService;
import alfa.gifty.service.ExchangeRateService;
import alfa.gifty.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GiftyRestController {

    private ExchangeRateService exchangeRateServer;
    private GiphyService giphyServer;
    private AlfaGiftyService alfaGiftyService;

    @Autowired
    public GiftyRestController(
            ExchangeRateService exchangeRateServer,
            GiphyService giphyServer,
            AlfaGiftyService alfaGiftyService
    ) {
        this.exchangeRateServer = exchangeRateServer;
        this.giphyServer = giphyServer;
        this.alfaGiftyService = alfaGiftyService;
    }

//    @GetMapping("/{code}")
    @RequestMapping(value = "/{code}", method = RequestMethod.GET,
        produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Map> postGif(@PathVariable String code) {

        alfaGiftyService.chooseGif(code);
        ResponseEntity<Map> result = giphyServer.getGif(gifTag);
        return result;
    }

}
