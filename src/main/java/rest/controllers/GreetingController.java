package rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import rest.config.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.db.QueryBuilder;
import rest.models.Test;

@RestController
public class GreetingController extends BaseRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(Path.GREETING)
    public List<Test> greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Test t = new Test();
        List<Test> response = new ArrayList<>();
        response.add(t);
        return response;
    }

    @RequestMapping(Path.ASD)
    public Test asd() {

        /*Test o = new Test();
        o.setTitle("Test Titrle");
        QueryBuilder.newSession(Test.class).save(o);*/

        //List<Test> a = QueryBuilder.newSession(Test.class).where().eq("id", UUID.fromString("4063dd6b-fa9c-4f45-98c1-4f40fa9f0d61")).list();
        //List<Test> a = QueryBuilder.newSession(Test.class).where().eq("id", UUID.fromString("4063dd6b-fa9c-4f45-98c1-4f40fa9f0d61")).list();

        return QueryBuilder
                .newSession(Test.class)
                .where()
                .notEq("id", UUID.fromString("4063dd6b-fa9c-4f45-98c1-4f40fa9f0d61"))
                .findOne();
    }


}