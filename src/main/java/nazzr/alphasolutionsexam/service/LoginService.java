package nazzr.alphasolutionsexam.service;

import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.repository.IUserRepository_DB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final IUserRepository_DB userRepository_db;

    public LoginService(ApplicationContext context, @Value("userRepo") String impl) {
        userRepository_db = (IUserRepository_DB) context.getBean(impl);
    }

    //---------------------------------------------------USER---------------------------------------------------------\\
    public User createUser(User user) {
        return userRepository_db.createUser(user);
    }

    public User getUser(String email, String password) {
        return userRepository_db.getUser(email, password);
    }

    public User getUserByEmail(String email) {
        return userRepository_db.getUserByEmail(email);
    }
}

