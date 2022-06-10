package alfa.gifty.client;

import org.springframework.http.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface FeignGiphyClient extends GiphyClient {

    @Override
    @GetMapping
    ResponseEntity<Map> getGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );
}
