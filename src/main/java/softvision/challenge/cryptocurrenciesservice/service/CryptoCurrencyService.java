package softvision.challenge.cryptocurrenciesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import softvision.challenge.cryptocurrenciesservice.models.CoinEntry;
import softvision.challenge.cryptocurrenciesservice.models.CoinList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CryptoCurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${crypto.compare.api.path}")
    private String cryptoCompareAPI;

    public CoinList getAllCoins() {
        return restTemplate.getForObject(cryptoCompareAPI + "/data/all/coinlist?api_key=" + apiKey, CoinList.class);
    }

    public Map<String, Object> getSingleConversion(String from, String to) {
        return restTemplate.getForObject(cryptoCompareAPI + "data/price?fsym=" + from + "&tsyms=" + to, HashMap.class);
    }

    public Map<String, Object> getConversion(String coin, int page) {
        final CoinList     allCoins             = getAllCoins();
        final List<String> allNames             = allCoins.getCoins().values().stream().map(CoinEntry::getName).collect(Collectors.toList());
        final List<String> namesByPage          = getCoinNames(allNames, page);
        final String       namesJoinedWithComma = String.join(",", namesByPage);
        return getSingleConversion(coin, namesJoinedWithComma);
    }

    private List<String> getCoinNames(List<String> allNames, int page) {
        final ArrayList<String> newNameList = new ArrayList<>();
        final int firstIndex = ((page - 1) * PAGE_SIZE) + 1;
        final int lastIndex  = page * PAGE_SIZE;
        for (int index = firstIndex; index <= lastIndex; index++ ) {
            newNameList.add(allNames.get(index));
        }
        return newNameList;
    }

    private static final int PAGE_SIZE = 50;
}
