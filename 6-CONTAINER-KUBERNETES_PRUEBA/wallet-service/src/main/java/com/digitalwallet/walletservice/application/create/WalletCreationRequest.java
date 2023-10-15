package com.digitalwallet.walletservice.application.create;

import com.digitalwallet.walletservice.domain.Customer;

public record WalletCreationRequest (String currency, Customer customer){
}
