package softvision.challenge.cryptocurrenciesservice.models;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Wallet{

    private Integer id;
    private String name;
    private List<Currency> currencyBalances;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet(Integer id, String name, List<Currency> currencyBalances) {
        this.id = id;
        this.name = name;
        this.currencyBalances = currencyBalances;
    }

    public HashMap<String, Double> getCurrencyBalances() {
        return (HashMap<String, Double>) currencyBalances.stream().collect(
                Collectors.toMap(Currency::getName, Currency::getBalance));
    }

    public void setCurrencyBalances(List<Currency> currencyBalances) {
        this.currencyBalances = currencyBalances;
    }

    public Wallet(){
    }


}