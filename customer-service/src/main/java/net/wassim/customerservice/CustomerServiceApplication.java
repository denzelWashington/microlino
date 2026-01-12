package net.wassim.customerservice;


import net.wassim.customerservice.entities.Customer;
import net.wassim.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
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
