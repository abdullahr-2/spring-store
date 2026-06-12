package ca.abdullahr2.springstore.services;

import ca.abdullahr2.springstore.entities.*;
import ca.abdullahr2.springstore.repositories.*;
import ca.abdullahr2.springstore.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
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
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecification(String name,
                                             BigDecimal minPrice,
                                             BigDecimal maxPrice) {

        Specification<Product> spec =
                (root, query, cb) -> cb.conjunction();

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec)
                .forEach(System.out::println);
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
        var profiles = userRepository.findLoyalUsers("2");
        profiles.forEach(p -> {
            System.out.println(p.getId() + ": " +p.getEmail());
        });
    }
}
