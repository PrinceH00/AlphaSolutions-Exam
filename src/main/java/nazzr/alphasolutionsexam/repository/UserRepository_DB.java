package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("userRepo")
public class UserRepository_DB implements IUserRepository_DB {

    String SQL = null;
    Connection connection = DB_Connector.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public User createUser(User user) {
        try {
            SQL = "INSERT INTO User(firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public User getUser(String email, String password) {
        try {
            SQL = "SELECT * FROM User WHERE email = ? AND password = ?";
            PreparedStatement preparedStatementUserID = connection.prepareStatement(SQL);
            preparedStatementUserID.setString(1, email);
            preparedStatementUserID.setString(2, password);

            return getUser(preparedStatementUserID);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUser(PreparedStatement preparedStatementUserEmail) throws SQLException {
        resultSet = preparedStatementUserEmail.executeQuery();

        User user = null;
        if (resultSet.next()) {
            int UserID = resultSet.getInt("user_id");
            String FirstName = resultSet.getString("firstName");
            String LastName = resultSet.getString("lastName");
            String Email = resultSet.getString("email");
            String Password = resultSet.getString("password");

            user = new User(UserID, FirstName, LastName, Email, Password);
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            SQL = "SELECT * FROM User WHERE email = ?";
            PreparedStatement preparedStatementUserEmail = connection.prepareStatement(SQL);
            preparedStatementUserEmail.setString(1, email);
            return getUser(preparedStatementUserEmail);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





