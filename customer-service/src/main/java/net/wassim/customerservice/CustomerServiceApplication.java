package net.wassim.customerservice;


import net.wassim.customerservice.entities.Customer;
import net.wassim.customerservice.learn.Homme;
import net.wassim.customerservice.learn.Vivre;
import net.wassim.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        String prefixe = "Salut ";

        // On crée l'ordre pour le robot
        Consumer<String> x = (message) -> System.out.println(prefixe+message);

        x.accept("Coucou !");


        Homme homme = new Homme();
        System.out.println(homme.age);


        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner db(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .firstName("Wassim")
                            .lastName("Sboui")
                    .email("wassim.sboui@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .firstName("Asma")
                    .lastName("Chebil")
                    .email("asma.chebil@yahoo.fr").build());
        };
    }

}
