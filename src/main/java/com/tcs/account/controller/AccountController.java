package com.tcs.account.controller;

import com.tcs.account.entity.Accounts;
import com.tcs.account.modal.CustomerRequest;
import com.tcs.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    Logger logger= LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/tcs/account-info")
    ResponseEntity<Accounts> getAccount(@RequestBody CustomerRequest customerRequest){
        logger.info("request for customer account info");
        Accounts accounts = accountRepository.findByCustomerId(customerRequest.getCustomerId());
        if (accounts != null) {
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.ok(null);
        }
    }
}
