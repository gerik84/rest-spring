package rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import rest.config.Path;
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
        throw new NullPointerException();
        //return "asd";
    }



}