package ca.abdullahr2.springstore;

import ca.abdullahr2.springstore.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringStoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringStoreApplication.class);
        var service = context.getBean(UserService.class);
        service.fetchUsers();
    }
}
