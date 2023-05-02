package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository_DB implements IUserRepository_DB {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String pwd;

    @Override
    public void createUser(User user) {
    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
