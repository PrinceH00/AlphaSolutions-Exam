package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "INSERT INTO User(firstname, lastname, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
