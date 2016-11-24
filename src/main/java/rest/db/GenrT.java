package rest.db;

import java.util.List;

/**
 * Created by redline on 24.11.16.
 */
public class GenrT<T> {

    private List<T> mList;

    public static <T> GenrT<T> doIt(Class<T> object) {
        return new GenrT<T>();
    }

    public List<T> getList() {
        return mList;
    }

}
