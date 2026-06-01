package ca.abdullahr2.springstore;

import ca.abdullahr2.springstore.entities.*;
import ca.abdullahr2.springstore.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringStoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringStoreApplication.class);
        var repository = context.getBean(UserRepository.class);

        repository.deleteById(1L);

    }
}
