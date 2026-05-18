package ca.abdullahr2.springstore;

public class UserService {
    UserRepository userRepository;
    NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {

    }
}
