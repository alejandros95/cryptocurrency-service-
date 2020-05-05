package softvision.challenge.cryptocurrenciesservice.service;

import org.springframework.stereotype.Service;
import softvision.challenge.cryptocurrenciesservice.models.Currency;
import softvision.challenge.cryptocurrenciesservice.models.Wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WalletService {

    private List<Wallet> wallets = new ArrayList<>();

    public List<Wallet> getAllWallets() {
        return wallets;
    }

    public Wallet getWallet(int id) throws Exception {
        final Optional<Wallet> option = wallets.stream().filter(wallet -> wallet.getId() == id).findFirst();
        if (!option.isPresent())
            throw new Exception("Wallet with id:"+ id + "doesn't exist!");
        return option.get();
    }


    public Wallet addWallet(Wallet wallet){
        wallets.add(wallet);
        return wallet;
    }

    public Wallet updateWallet(Wallet updatedWallet) {
        for (int index = 0; index < wallets.size(); index++) {
            final Wallet wallet = wallets.get(index);
            if(wallet.getId().equals(updatedWallet.getId())) {
                wallets.set(index, updatedWallet);
                return updatedWallet;
            }
        }
        return updatedWallet;
    }

    public void deleteWallet(int walletId) {
        wallets.removeIf(wallet -> wallet.getId() == walletId);
    }

    protected void updateCurrency(int walletId, Double currencyValue, String currency) throws Exception {
        final Wallet wallet           = getWallet(walletId);
        final Double currencyBalance  = wallet.getCurrencyBalances().get(currency);
        final Double finalBalance     = currencyBalance == null ? currencyValue : currencyBalance + currencyValue;
        final HashMap<String, Double> currencyBalances = wallet.getCurrencyBalances();

        if (finalBalance == 0.0) currencyBalances.remove(currency, finalBalance);
        else currencyBalances.put(currency, finalBalance);

        final List<Currency> finalCurrencies = currencyBalances.entrySet()
                .stream()
                .map(e -> new Currency(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        wallet.setCurrencyBalances(finalCurrencies);
    }
}
