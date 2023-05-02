package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;

public interface IUserRepository_DB {
    User createUser(User user);
    User getUser(String email, String password);
}
