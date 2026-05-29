package ca.abdullahr2.springstore;

import ca.abdullahr2.springstore.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringStoreApplication {

    public static void main(String[] args) {
        User user = User.builder()
                .name("Abdullah")
                .email("abrlacc4578@gmail.com")
                .password("pass")
                .build();

    }
}
