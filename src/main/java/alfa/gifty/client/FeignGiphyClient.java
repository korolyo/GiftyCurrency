package alfa.gifty.client;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "giphy", url = "${giphy.url}")
public interface FeignGiphyClient extends GiphyClient {

    @Override
    @GetMapping
    String getGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );
}
