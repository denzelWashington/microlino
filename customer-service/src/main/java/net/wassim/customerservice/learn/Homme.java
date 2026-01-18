package net.wassim.customerservice.learn;

import org.springframework.context.annotation.Bean;


public class Homme extends Vivre {

    @Bean
    public void execution() {
        System.out.println("Homme executou");
    }
}
