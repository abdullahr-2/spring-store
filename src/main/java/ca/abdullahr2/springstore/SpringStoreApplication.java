package ca.abdullahr2.springstore;

import ca.abdullahr2.springstore.entities.Address;
import ca.abdullahr2.springstore.entities.Profile;
import ca.abdullahr2.springstore.entities.Tag;
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
        Address address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();
        Profile profile  = Profile.builder()
                .bio("bio")
                .build();

        user.setProfile(profile);

        System.out.println(user);
    }

}
