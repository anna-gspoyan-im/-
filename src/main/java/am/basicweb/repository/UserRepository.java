package am.basicweb.repository;

import am.basicweb.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> getbyUserNameAndPassword(String username, String password) throws SQLException;

    User getbyUserName(String username) throws SQLException;

    User gUsername(String username) throws SQLException;

    void add1(String surname, int age, String password, String name, String username, String code) throws SQLException;

    void addUser(User user) throws SQLException;

    void delete(String password, String username) throws SQLException;

    void update(User user) throws SQLException;
}
