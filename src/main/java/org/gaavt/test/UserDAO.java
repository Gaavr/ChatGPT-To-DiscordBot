package org.gaavt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class UserDAO {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создание SessionFactory из hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<UserEntity> getUsers() {
        // Получаем session
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from UserEntity", UserEntity.class).list();
        } catch (HibernateException he) {
            // В реальной жизни здесь вы бы вероятно логировали это исключение, а не выводили бы просто на экран.
            he.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Если вам понадобится завершить работу с Hibernate и освободить ресурсы, вы можете добавить следующий метод:
    public static void shutdown() {
        // Закрыть кэши и соединение с пулами
        getSessionFactory().close();
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

