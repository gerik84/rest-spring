package rest.db;

import org.hibernate.Session;
import org.hibernate.query.Query;
import rest.models.Test;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

/**
 * Created by redline on 23.11.16.
 */
public class QueryBuilder<T> {

    public static <T> QueryBuilder<T> newInstance(Class<T> clazz) {
        return new QueryBuilder<T>(clazz);
    }

    private Session mSession = HibernateUtil.buildSessionFactory().openSession();
    private CriteriaQuery<T> mCriteriaQuery;
    Root<T> mEntity;

    public QueryBuilder(Class<T> clazz) {
        mCriteriaQuery = mSession.getCriteriaBuilder().createQuery(clazz);
        mEntity = mCriteriaQuery.from(clazz);
    }

    public CriteriaQuery<T> getCriteria() {
        return mCriteriaQuery;
    }

    private Session getSession() {
        return mSession == null ? mSession = HibernateUtil.buildSessionFactory().openSession() : mSession;
    }

    public QueryBuilder<T> where() {
        Predicate p = mSession.getCriteriaBuilder().equal(mEntity.get("id"), UUID.fromString("0100437e-91e5-4cf7-b69c-89802571f631"));
        Predicate p1 = mSession.getCriteriaBuilder().equal(mEntity.get("title"), "asd");

        mCriteriaQuery.where(p, p1);
        return this;
    }

    public T findOne() {
        return list().get(0);
    }

    public List<T> list() {
        List<T> list = mSession.createQuery(mCriteriaQuery).list();
        mSession.close();
        return list;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (mSession != null)
            mSession.close();
    }

    public static class PredicateCreate<T> {

    }
}
