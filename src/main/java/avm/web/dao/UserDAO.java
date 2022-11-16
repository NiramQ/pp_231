package avm.web.dao;

import avm.web.models.Person;

import java.util.List;

public interface UserDAO {

    void saveUser(Person user);

    void updateUser(Person user, int id);

    void removeUser(int id);

    Person getUserById(int id);

    List<Person> getListUsers();
}
