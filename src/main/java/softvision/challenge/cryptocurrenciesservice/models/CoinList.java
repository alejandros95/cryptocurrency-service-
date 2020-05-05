package softvision.challenge.cryptocurrenciesservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CoinList {
    private Map<String, CoinEntry> coins;

    //empty constructor
    public CoinList(){}

    @JsonProperty("Data")
    public Map<String, CoinEntry> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, CoinEntry> coins) {
        this.coins = coins;
    }

    public CoinList(Map<String, CoinEntry> coins) {
        this.coins = coins;
    }


}
