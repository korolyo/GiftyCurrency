package alfa.gifty.service;

import alfa.gifty.client.GiphyClient;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GiphyServiceImpl implements GiphyService {

    private GiphyClient giphyClient;
    @Value("${giphy.api_key}")
    private String apiKey;

    @Autowired
    public GiphyServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;
    }

    @Override
    public String getGif(String tag) {
        String result = giphyClient.getGif(this.apiKey, tag);
        return result;
    }
}
