package alfa.gifty.controller;

import alfa.gifty.service.AlfaGiftyService;
import alfa.gifty.service.ExchangeRateService;
import alfa.gifty.service.GiphyService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static java.lang.System.in;

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

    @GetMapping("/{code}")
    public String postGif(@PathVariable String code) {
        String gifUrl = alfaGiftyService.chooseGif(code);
        System.out.println(gifUrl);
        return "<img src=\"" + gifUrl + "\" alt=\"there should be gif, please set currency correctly\"  width=250/>";
    }
}
