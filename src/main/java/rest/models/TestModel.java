package rest.models;

import java.util.UUID;

/**
 * Created by redline on 18.11.16.
 */
public class TestModel {

    public UUID id;
    public String name;

    public TestModel() {
        this.id = UUID.randomUUID();
    }

}
