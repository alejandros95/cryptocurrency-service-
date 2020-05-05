package softvision.challenge.cryptocurrenciesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softvision.challenge.cryptocurrenciesservice.models.Wallet;

import java.util.Map;

@Service
public class TransferService {

    @Autowired
    WalletService walletService;

    @Autowired
    CryptoCurrencyService cryptoCurrencyService;

    public void transferCurrency(double originValue, String originCurrency, int originWalletId,
                                  String destCurrency, int destWalletId) throws Exception {
        final Wallet oWallet = walletService.getWallet(originWalletId);
        final Double oCurrencyBalance = oWallet.getCurrencyBalances().get(originCurrency);
        if (oCurrencyBalance == null)
            throw new Exception("Wallet with id:" + originWalletId + " doesn't have currency:" + originCurrency);

        if (oCurrencyBalance < originValue)
            throw new Exception(originValue + "is < than current " + originCurrency + " balance" + oCurrencyBalance);

        final double creditCurrencyValue;
        if (!originCurrency.equals(destCurrency)) {
            final Map<String, Object> conversionMap = cryptoCurrencyService.getSingleConversion(originCurrency, destCurrency);
            final Double creditConvertionValue = (Double) conversionMap.get(destCurrency);
            if (creditConvertionValue == null)
                throw new Exception("Transaction between " + originCurrency + " and " + destCurrency + " is not possible");
            creditCurrencyValue = creditConvertionValue * originValue;
        }
        else creditCurrencyValue = originValue;

        walletService.updateCurrency(originWalletId, -originValue, originCurrency);
        walletService.updateCurrency(destWalletId, creditCurrencyValue, destCurrency);
    }
}
