package alfa.gifty.client;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GiphyClient {

    ResponseEntity<Map> getGif(String apiKey, String tag);
}
