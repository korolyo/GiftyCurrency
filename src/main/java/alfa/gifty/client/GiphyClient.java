package alfa.gifty.client;

import com.fasterxml.jackson.core.JsonParser;

public interface GiphyClient {

    String getGif(String apiKey, String tag);
}
