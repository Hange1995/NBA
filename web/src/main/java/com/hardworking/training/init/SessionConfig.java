package com.hardworking.training.init;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class SessionConfig {
    private static SessionFactory sessionFactory;
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    @Bean
    public static SessionFactory getSessionFactory() {
        //first time invoke
        if (sessionFactory == null) {
            //construct session factory
            try {
                String[] modelPackages = {"com.hardworking.training.model"};
                //Passing VM options.
                String dbDriver = System.getProperty("database.driver");
                String dbDialect = System.getProperty("database.dialect");
                String dbUrl = "jdbc:postgresql://"+System.getProperty("database.url")+":"+System.getProperty("database.port")+"/"+System.getProperty("database.name");;
                String dbUser = System.getProperty("database.user");
                String dbPassword = System.getProperty("database.password");
                org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, dbDriver);
                settings.put(Environment.DIALECT, dbDialect);
                settings.put(Environment.URL, dbUrl);
                settings.put(Environment.USER, dbUser);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                EntityScanner.scanPackages(modelPackages).addTo(configuration);
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = registryBuilder.applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e) {
                logger.error("fail to generate hibernate sessionfactory",e);
            }
        }
        return sessionFactory;
    }
}
