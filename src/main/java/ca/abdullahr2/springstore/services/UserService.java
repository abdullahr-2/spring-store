package ca.abdullahr2.springstore.services;

import ca.abdullahr2.springstore.entities.*;
import ca.abdullahr2.springstore.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void manageProducts() {
        productRepository.deleteById(3L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10.99), (byte) 2);
    }

    @Transactional
    public void showEntityStates() {
        User user = User.builder()
                .name("ar")
                .email("ar@gmail.com")
                .password("pass")
                .build();

        if (entityManager.contains(user)){
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }

        userRepository.save(user);

        if (entityManager.contains(user)){
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        Profile profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        Address address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        User user = User.builder()
                .name("John Doe")
                .email("john.doe@gmail.com")
                .password("password")
                .build();

        Address address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        User user = userRepository.findById(4L).orElseThrow();
        Address address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void fetchProducts() {
        var products = productRepository.findProducts(BigDecimal.valueOf(5), BigDecimal.valueOf(15));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUsers() {
        var users = userRepository.findAllWithAddresses();
        users.forEach(user -> {
            System.out.println(user);
            user.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void fetchProfiles() {
        var profiles = profileRepository.findByLoyaltyPointsGreaterThan("2");
        profiles.forEach(p -> {
            System.out.println(p.getId() + ": " +p.getUser().getEmail());
        });
    }
}
