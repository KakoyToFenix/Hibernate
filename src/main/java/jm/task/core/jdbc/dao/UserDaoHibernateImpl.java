package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    private final static SessionFactory sessionFactory;

    static {
        sessionFactory = Util.getSessionFactory(); // Создаем SessionFactory один раз
    }

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS `user`(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), lastName VARCHAR(255), age TINYINT)")
                .executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createSQLQuery("DROP TABLE IF EXISTS `user`").executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
        System.out.printf("User с именем - %s добавлен в базу данных.%n", name);
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(session.get(User.class, id));
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = sessionFactory.openSession();
        users = session.createQuery("FROM User", User.class).getResultList();

        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.createSQLQuery("DELETE FROM  `user`").executeUpdate();
        session.getTransaction().commit();
    }
}
