package alfa.gifty.model;

import java.util.Map;

public class ExchangeRate {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;


    public ExchangeRate() { }

    public ExchangeRate(String disclaimer, String license, String timestamp, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public java.lang.String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public java.lang.String getLicense() {
        return license;
    }

    public void setLicense(java.lang.String license) {
        this.license = license;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
