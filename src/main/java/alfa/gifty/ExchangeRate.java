package alfa.gifty;

import java.time.LocalDateTime;
import java.util.Map;

public class ExchangeRate {
    private String disclaimer;
    private String license;
    private LocalDateTime timestamp;
    private Map<String, Double> rates;

    public ExchangeRate(String disclaimer, String license, LocalDateTime timestamp, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.rates = rates;
    }

    public java.lang.String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(java.lang.String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public java.lang.String getLicense() {
        return license;
    }

    public void setLicense(java.lang.String license) {
        this.license = license;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
