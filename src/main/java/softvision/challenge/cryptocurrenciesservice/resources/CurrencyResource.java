package softvision.challenge.cryptocurrenciesservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softvision.challenge.cryptocurrenciesservice.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyResource {

    @Autowired
    CurrencyService currencyService;

    @PutMapping("/buy/origin-value={oValue}&" +
                "origin-currency={oCurrency}&" +
                "dest-currency={dCurrency}&" +
                "origin-wallet={oWallet}")
    public void buyCurrency(@PathVariable("oValue") double oValue,
                              @PathVariable("oCurrency") String oCurrency,
                              @PathVariable("dCurrency") String dCurrency,
                              @PathVariable("oWallet") int oWallet) throws Exception {
        currencyService.buyCurrency(oValue, oCurrency, dCurrency, oWallet);
    }


}
