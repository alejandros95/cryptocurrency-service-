package softvision.challenge.cryptocurrenciesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softvision.challenge.cryptocurrenciesservice.models.Wallet;

import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    WalletService walletService;

    @Autowired
    CryptoCurrencyService cryptoCurrencyService;

    public Wallet buyCurrency(double debitValue, String originCurrency, String destCurrency, int walletId) throws Exception {
        final Wallet wallet = walletService.getWallet(walletId);
        final Double oCurrencyBalance = wallet.getCurrencyBalances().get(originCurrency);
        if (oCurrencyBalance == null)
            throw new Exception("Wallet with id:" + walletId + " doesn't have currency:" + originCurrency);

        if (oCurrencyBalance < debitValue)
            throw new Exception(debitValue + "is < than current " + originCurrency + " balance" + oCurrencyBalance);

        final Map<String, Object> conversionMap = cryptoCurrencyService.getSingleConversion(originCurrency, destCurrency);
        final Double creditConvertionValue = (Double) conversionMap.get(destCurrency);
        if (creditConvertionValue == null)
            throw new Exception("Transaction between " + originCurrency + " and " + destCurrency + " is not possible");

        walletService.updateCurrency(walletId, -debitValue, originCurrency);

        final Double creditValue = creditConvertionValue * debitValue;
        walletService.updateCurrency(walletId, creditValue, destCurrency);

        return walletService.getWallet(walletId);
    }


}
