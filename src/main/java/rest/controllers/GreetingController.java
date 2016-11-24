package rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import rest.config.Path;
import rest.db.GenrT;
import rest.db.HibernateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.db.QueryBuilder;
import rest.models.Test;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@RestController
public class GreetingController extends BaseRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(Path.GREETING)
    public List<Test> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        Test t = new Test();
        List<Test> response = new ArrayList<>();
        response.add(t);
        return response;
    }

    @RequestMapping(Path.ASD)
    public List<Test> asd() {

        //Test ss = QueryBuilder.newInstance(Test.class).where().findOne();

        List<Test> a = QueryBuilder.newInstance(Test.class).where().list();

//        HibernateUtil.select(Test.class);
//
//        Session session1 = HibernateUtil.getSessionFactory().openSession();
//        CriteriaQuery<Test> criteriaQuery = session1.getCriteriaBuilder().createQuery(Test.class);
//        criteriaQuery.from(Test.class);
//            List<Test> tests = session1.createQuery(criteriaQuery).list();
//        session1.close();

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.setProperty("hibernate.show_sql", "true");
//        session.beginTransaction();
//        Test contactEntity = new Test();
////        contactEntity.setId(UUID.randomUUID());
//        contactEntity.setTitle("asd");
//
//        session.save(contactEntity);
//        session.getTransaction().commit();
//        session.close();
        return a;
    }



}