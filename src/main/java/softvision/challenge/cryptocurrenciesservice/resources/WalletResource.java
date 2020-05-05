package softvision.challenge.cryptocurrenciesservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softvision.challenge.cryptocurrenciesservice.models.Wallet;
import softvision.challenge.cryptocurrenciesservice.service.WalletService;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletResource {

    @Autowired
    private WalletService walletService;


    @RequestMapping("/all")
    public List<Wallet> getAllWallets(){
        return walletService.getAllWallets();
    }

    @GetMapping("/{walletId}")
    public Wallet getWallet(@PathVariable("walletId") int walletId) throws Exception {
        return walletService.getWallet(walletId);
    }

    @PostMapping("/create")
    public Wallet addWallet(@RequestBody Wallet wallet){
        return walletService.addWallet(wallet);
    }

    @PutMapping("/update")
    public Wallet updateWallet(@RequestBody Wallet wallet){
        return walletService.updateWallet(wallet);
    }

    @DeleteMapping("/delete/{walletId}")
    public void deleteWallet(@PathVariable("walletId") int walletId){
        walletService.deleteWallet(walletId);
    }
}
