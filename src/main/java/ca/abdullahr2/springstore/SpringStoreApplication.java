package ca.abdullahr2.springstore;

import ca.abdullahr2.springstore.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
