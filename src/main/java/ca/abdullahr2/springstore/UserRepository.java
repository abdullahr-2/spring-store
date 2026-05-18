package ca.abdullahr2.springstore;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
