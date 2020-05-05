README DOCUMENTATION


source code
https://github.com/alejandros95/cryptocurrency-service-


--------------------------------------------------------------------------------------------------


Get All CryptoCurrencies Service
method get
https://crypto-currency-service.herokuapp.com/cryptocurrency/coin/all/{currency}/page={page}
inputs
currency: type string(i.e. USD, BTC)
page: type int




i.e.:
https://crypto-currency-service.herokuapp.com/cryptocurrency/coin/all/USD/page=1


--------------------------------------------------------------------------------------------------
Create Wallet Service
method post
https://crypto-currency-service.herokuapp.com/wallet/create
input json
json body:


{
    "id": int,
    "name": string,
    "currencyBalances": [
        {
            "name": string(currency USD, BTC..),
            "balance": double
        }
    ]
}


i.e.:


{
    "id": 1,
    "name": "Alejandro",
    "currencyBalances": [
        {
            "name": "USD",
            "balance": 1
        }
    ]
}


--------------------------------------------------------------------------------------------------


Get Wallet Service


method get
https://crypto-currency-service.herokuapp.com/wallet/{walletId}
input walletId


--------------------------------------------------------------------------------------------------


Update Wallet Service


method put
https://crypto-currency-service.herokuapp.com/wallet/update/{walletId}
inputs walletId, json body


json body 
{
    "id": int,
    "name": string,
    "currencyBalances": [
        {
            "name": string(currency USD, BTC..),
            "balance": double
        }
    ]
}


--------------------------------------------------------------------------------------------------


Delete Wallet Service


method delete
https://crypto-currency-service.herokuapp.com/wallet/delete/{walletId}
inputs walletID


--------------------------------------------------------------------------------------------------


Buy Currency Service


method put
https://crypto-currency-service.herokuapp.com/currency/buy/origin-value={oValue}&origin-currency={oCurrency}&dest-currency={dCurrency}&origin-wallet={oWallet}


inputs:
double oValue= the value taken to buy currency
string oCurrency= the origin currency 
string dCurrency= the destination currency
int    oWallet= wallet id


i.e.
https://crypto-currency-service.herokuapp.com/currency/buy/origin-value=1000&origin-currency=USD&dest-currency=BTC&origin-wallet=1


-------------------------------------------------------------------------------------------------


Transfer Values for two Wallets Service


method put
https://crypto-currency-service.herokuapp.com/transfer/origin-value={oValue}&origin-currency={oCurrency}&origin-wallet={oWallet}&dest-currency={dCurrency}&dest-wallet={dWallet}


inputs:
double oValue= 
string oCurrency
int    oWallet
string dCurrency
int    dWallet


i.e.:
https://crypto-currency-service.herokuapp.com/transfer/origin-value=1000&origin-currency=USD&origin-wallet=1&dest-currency=BTC&dest-wallet=20