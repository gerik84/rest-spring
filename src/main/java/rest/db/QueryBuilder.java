package rest.db;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redline on 23.11.16.
 */
public class QueryBuilder<T> {

    public static <T> QueryBuilder<T> newSession(Class<T> clazz) {
        return new QueryBuilder<T>(clazz);
    }

    private Session mSession = HibernateUtil.buildSessionFactory().openSession();

    private PredicateCreate mPredicateCreate;

    private QueryBuilder(Class<T> clazz) {
        mPredicateCreate  = new PredicateCreate(mSession, clazz);
    }

    private Session getSession() {
        return mSession == null ? mSession = HibernateUtil.buildSessionFactory().openSession() : mSession;
    }

    public PredicateCreate where() {
//        Predicate p = mSession.getCriteriaBuilder().equal(mEntity.get("id"), UUID.fromString("0100437e-91e5-4cf7-b69c-89802571f631"));
//        Predicate p1 = mSession.getCriteriaBuilder().equal(mEntity.get("title"), "asd");

        return mPredicateCreate;
    }

    public T save(T object) {
        mSession.beginTransaction();
        mSession.save(object);
        mSession.getTransaction().commit();
        mSession.close();
        return object;
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (mSession != null)
            mSession.close();
    }

    public class PredicateCreate {

        Session mSession;
        CriteriaBuilder mCriteriaBuilder;
        CriteriaQuery<T> mCriteriaQuery;
        Root<T> mEntity;

        private List<Predicate> predicates;

        PredicateCreate(Session session, Class<T> clazz) {
            mSession = session;
            mCriteriaBuilder = mSession.getCriteriaBuilder();
            mCriteriaQuery = mCriteriaBuilder.createQuery(clazz);
            mEntity = mCriteriaQuery.from(clazz);

            predicates = new ArrayList<>();
        }

        public PredicateCreate eq(String field, Object value) {
            predicates.add(mCriteriaBuilder.equal(mEntity.get(field).as(value.getClass()), value));
            return this;
        }

        public PredicateCreate notEq(String field, Object value) {
            predicates.add(mCriteriaBuilder.and());
            predicates.add(mCriteriaBuilder.notEqual(mEntity.get(field).as(value.getClass()), value));
            return this;
        }

        public PredicateCreate and(List<Predicate> predicates) {
//            Ebean.createQuery(Test.class).where().and()
            predicates.add(mCriteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return this;
        }

        public PredicateCreate gt(String field, Object value) {
            predicates.add(mCriteriaBuilder.equal(mEntity.get(field).as(value.getClass()), value));
            return this;
        }

//        public PredicateCreate like(String field, Object value) {
//            predicates.add(mCriteriaBuilder.like(mEntity.get(field).as(value.getClass()), value));
//            return this;
//        }

//        public PredicateCreate in(String field, Object value) {
//            predicates.add(mCriteriaBuilder.in(mEntity.get(field).as(value.getClass()), value));
//            return this;
//        }

        private void createWhere() {
            for (Predicate p : predicates) {
                mCriteriaQuery.where(p);
            }
        }

        public List<T> list() {
            createWhere();
            List<T> list = mSession.createQuery(mCriteriaQuery).list();
            mSession.close();
            return list;
        }

        public T findOne() {
            return list().get(0);
        }


    }
}
