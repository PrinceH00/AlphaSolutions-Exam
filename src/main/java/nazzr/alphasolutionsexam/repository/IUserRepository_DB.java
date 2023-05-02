package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.User;

public interface IUserRepository_DB {
    void createUser(User user);
    void editUser(User user);
    void deleteUser(int id);
}
