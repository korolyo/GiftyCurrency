package alfa.gifty.service;

import alfa.gifty.client.GiphyClient;
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
    public ResponseEntity<Map> getGif(String tag) {
        ResponseEntity<Map> result = giphyClient.getGif(this.apiKey, tag);
        result.getBody().put("compareResult", tag);
        return result;
    }
}
