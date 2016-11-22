package rest.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by redline on 22.11.16.
 */

@Entity
@Table(name = "test")
public class Test {

    @Column
    public int id;

    @Column
    public String title;

}
