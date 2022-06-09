package alfa.gifty.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangerateRestController {

    @PostMapping("/latest")
    public void postTodayRate(@PathVariable) {

    }

    @PostMapping("/historical")
    public void postYesterdayRate() {

    }

}
