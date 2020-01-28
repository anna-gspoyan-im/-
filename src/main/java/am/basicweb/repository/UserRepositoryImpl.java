package am.basicweb.repository;

import am.basicweb.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void init1() {
        System.out.println("init1-UserRepositoryImpl");
    }

    public void destroy1() {
        System.out.println("destroy1-UserRepositoryImpl");
    }

    public List<User> getbyUserNameAndPassword(String username, String password) throws SQLException {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("SELECT * FROM  user WHERE password=? AND username=?", User.class);
        query.setParameter(1, password);
        query.setParameter(2, username);
        return query.list();
    }

    public User getById(long id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }

    @Transactional(readOnly = true)
    public User getbyUserName(String username) throws SQLException {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("select * from user where  username=?", User.class);
        query.setParameter(1, username);
        return query.uniqueResult();

    }

    @Override
    public User gUsername(String username) throws SQLException {
        return null;
    }

    @Override
    public void add1(String surname, int age, String password, String name, String username, String code) throws SQLException {

    }

    @Transactional
    public void addUser(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void delete(String password, String username) throws SQLException {

    }

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class,noRollbackFor = ThreadDeath.class)
    public void delete(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);

    }

    @Transactional
    public void update(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

}
