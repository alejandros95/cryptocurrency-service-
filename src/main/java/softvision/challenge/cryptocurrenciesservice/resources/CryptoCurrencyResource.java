package softvision.challenge.cryptocurrenciesservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softvision.challenge.cryptocurrenciesservice.service.CryptoCurrencyService;

import java.util.Map;

@RestController
@RequestMapping("/cryptocurrency/coin")
public class CryptoCurrencyResource {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;

    @RequestMapping("/all/{coin}/page={page}")
    public Map<String, Object> getConversion(@PathVariable("coin") String coin, @PathVariable("page") int page) {
        return cryptoCurrencyService.getConversion(coin, page);
    }

}
