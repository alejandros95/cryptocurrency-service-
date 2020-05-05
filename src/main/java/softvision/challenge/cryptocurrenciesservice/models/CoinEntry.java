package softvision.challenge.cryptocurrenciesservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinEntry {

    //empty constructor
    public CoinEntry(){}

    private int id;
    private String name;
    private String symbol;

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CoinEntry(int id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }
}
