package alfa.gifty.controller;

import alfa.gifty.server.ExchangeRateServer;
import alfa.gifty.server.GiphyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gif")
public class GiftyRestController {

    private ExchangeRateServer exchangeRateServer;
    private GiphyServer giphyServer;

    @Autowired
    public GiftyRestController(
            ExchangeRateServer exchangeRateServer,
            GiphyServer giphyServer
    ) {
        this.exchangeRateServer = exchangeRateServer;
        this.giphyServer = giphyServer;
    }

    @GetMapping("/hello")
    public String postTodayRate() {
        return "You broke";
    }

}
