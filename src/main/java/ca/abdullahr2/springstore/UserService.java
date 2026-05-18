package ca.abdullahr2.springstore;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " is already registered");
        }
        userRepository.save(user);
        notificationService.send("Successfully registered user", "remail@gmail.com");
    }
}
