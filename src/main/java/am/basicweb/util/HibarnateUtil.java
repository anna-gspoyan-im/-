package am.basicweb.util;

import am.basicweb.model.Action;
import am.basicweb.model.Card;
import am.basicweb.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.nio.channels.AcceptPendingException;
import java.util.Properties;


public class HibarnateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

                Configuration configuration = new Configuration();


                // Hibernate settings equivalent to hibernate.cfg.xml's properties

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Test");

                settings.put(Environment.USER, "root");

                settings.put(Environment.PASS, "");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");


                settings.put(Environment.SHOW_SQL, "true");



                settings.put(Environment.HBM2DDL_AUTO, "update");


                configuration.setProperties(settings);


                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Card.class);
                configuration.addAnnotatedClass(Action.class);



                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

                        .applySettings(configuration.getProperties()).build();


                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return sessionFactory;

    }
}
