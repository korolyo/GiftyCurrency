package alfa.gifty.core;

import alfa.gifty.client.FeignExchangeRateClient;
import alfa.gifty.client.FeignGiphyClient;
import alfa.gifty.controller.GiftyRestController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConrollerTest {

	@MockBean
	FeignGiphyClient feignGiphyClient;

	@MockBean
	FeignExchangeRateClient feignExchangeRateClient;

	@Autowired
	GiftyRestController giftyRestController;

	@Test
	public void isGifReceivedWhenCurrencySame() {

		final String currency = "RUB";
		final String gifType = "rich";
		final String currencyRateToday = "74.035";
		final String currencyRateYesterday = "74.035";
		final String gifUrl = "https://media1.giphy.com/media/1URYREdZievwIFZugg/200.gif?cid=" +
				"LQIz0s73ixRR5Tn9uGNSPWumkNF1vVMk&rid=200.gif";

		Mockito.when(feignGiphyClient.getGif("LQIz0s73ixRR5Tn9uGNSPWumkNF1vVMk", gifType))
				.thenReturn(gifUrl);


		assertThat(giftyRestController.postGif(currency)).contains(gifUrl);
	}
}