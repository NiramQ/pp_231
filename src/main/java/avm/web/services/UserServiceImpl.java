package avm.web.services;

import avm.web.dao.UserDAO;
import avm.web.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<Person> getListUsers() {
        return userDAO.getListUsers();
    }

    @Override
    @Transactional
    public void saveUser(Person user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Person user, int id) {
        userDAO.updateUser(user, id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    public Person getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
