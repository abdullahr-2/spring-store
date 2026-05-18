package ca.abdullahr2.springstore;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepository{
    /**
     * Hashmap to store users
     * Key: User email
     * Value: User
     */
    HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }
}
