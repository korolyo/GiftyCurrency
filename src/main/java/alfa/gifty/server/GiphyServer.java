package alfa.gifty.server;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GiphyServer {

    ResponseEntity<Map> setGif(String tag);
}
