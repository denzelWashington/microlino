package net.wassim.accountservice.services;


import lombok.AllArgsConstructor;
import net.wassim.accountservice.clients.CustomerRestClient;
import net.wassim.accountservice.entities.BankAccount;
import net.wassim.accountservice.model.Customer;
import net.wassim.accountservice.repository.BankRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api")
public class BankController {

    private BankRepository bankRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping(path = "/accounts")
    public List<BankAccount> bankAccountList() {
        return bankRepository.findAll();
    }

    @GetMapping(path = "/accounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        BankAccount bankAccount = bankRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
