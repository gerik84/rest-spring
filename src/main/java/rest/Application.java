package rest;

import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import rest.db.HibernateSessionFactory;
import rest.models.Test;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {



        SpringApplication.run(Application.class, args);
    }
}