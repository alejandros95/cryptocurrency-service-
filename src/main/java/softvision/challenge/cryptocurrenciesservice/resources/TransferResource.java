package softvision.challenge.cryptocurrenciesservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softvision.challenge.cryptocurrenciesservice.service.TransferService;

@RestController
@RequestMapping("/currency")
public class TransferResource {

    @Autowired
    TransferService transferService;


    @PutMapping("/transfer/origin-value={oValue}&" +
            "origin-currency={oCurrency}&" +
            "origin-wallet={oWallet}&" +
            "dest-currency={dCurrency}&" +
            "dest-wallet={dWallet}")
    public void transferCurrency(@PathVariable("oValue") double oValue,
                            @PathVariable("oCurrency") String oCurrency,
                            @PathVariable("oWallet") int oWallet,
                            @PathVariable("dCurrency") String dCurrency,
                            @PathVariable("dWallet") int dWallet) throws Exception {
        transferService.transferCurrency(oValue, oCurrency, oWallet, dCurrency, dWallet);
    }
}
