package ca.abdullahr2.springstore.entities;

import ca.abdullahr2.springstore.repositories.AddressRepository;
import ca.abdullahr2.springstore.repositories.ProfileRepository;
import ca.abdullahr2.springstore.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;

    public void fetchAddress() {
        Address address = addressRepository.findById(1L).orElseThrow();
    }
}
