package net.wassim.accountservice;


import net.wassim.accountservice.entities.BankAccount;
import net.wassim.accountservice.enums.AccountType;
import net.wassim.accountservice.repository.BankRepository;
import net.wassim.accountservice.strategy.CreditCardPayment;
import net.wassim.accountservice.strategy.PaymentContext;
import net.wassim.accountservice.strategy.PaymentService;
import net.wassim.accountservice.strategy.PaypalPayment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountserviceApplication {

    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPayment(new CreditCardPayment());
        paymentContext.executePayment();

        SpringApplication.run(AccountserviceApplication.class, args);

        Integer a = 10; Integer b = 10;
        boolean b1 = a == b;

        Integer c = new Integer(10); Integer d = new Integer(10);
        boolean b2 = c == d;
        boolean b3 = c.equals(d);

        System.out.println("verif 1: " + b1);
        System.out.println("verif 2: "+ c +" - "+ d + b2 + " "+b3);


        String s = "bonjour";
        s.toUpperCase();
        Integer xx = 10;
        xx = 8;
        System.out.println(s);
        System.out.println(xx);

        StringBuilder ss = new StringBuilder("hello");
        ss.append(" Wassim");
        System.out.println(ss);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(18);
        arrayList.add(20);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(9);
        linkedList.add(18);
        linkedList.add(20);

        linkedList.get(1);


        System.out.println("cc "+new Object().hashCode());

    }

    @Bean
    CommandLineRunner db(BankRepository bankRepository) {
        return args -> {
            bankRepository.save(
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString()).balance(56.87)
                            .type(AccountType.CURRENT_ACCOUNT)
                            .createdAt(LocalDate.now())
                            .customerId(2L)
                            .currency("euros").build()
            );

            bankRepository.save(
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString()).balance(12000)
                            .type(AccountType.CURRENT_ACCOUNT)
                            .createdAt(LocalDate.now())
                            .customerId(1L)
                            .currency("dinars").build()
            );

        };
    }
}