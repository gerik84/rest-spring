package rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import rest.config.Path;
import rest.db.HibernateUtil;
import rest.models.Test;
import rest.models.TestModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController extends BaseRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(Path.GREETING)
    public List<TestModel> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        TestModel t = new TestModel();
        t.name = "test";
        TestModel t2 = new TestModel();
        t2.name = "test";
        List<TestModel> response = new ArrayList<>();
        response.add(t);
        response.add(t2);
        return response;
    }

    @RequestMapping(Path.ASD)
    public String asd() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Test contactEntity = new Test();

        contactEntity.id = 1;
        contactEntity.title = "as";

        session.save(contactEntity);
        session.getTransaction().commit();
        session.close();
        throw new NullPointerException("Object not found");
        //return "asd";
    }



}