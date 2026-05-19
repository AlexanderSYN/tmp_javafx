package ru.zelmex.bankapp.repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.zelmex.bankapp.util.HibernateSessionFactoryUtil;
import java.util.List;
public abstract class BaseDao<T> {
    private Class<T> clazz;
    public BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }
    protected Session getCurrentSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
    }
    public void save(final T entity) {
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(entity);
        tx1.commit();
        session.close();
    }
    public void update(final T entity) {
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(entity);
        tx1.commit();
        session.close();
    }
    public void delete(final T entity) {
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(entity);
        tx1.commit();
        session.close();
    }
    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
    public T findOne(final long id) {
        Session session = getCurrentSession();
        session.beginTransaction();
        T item = session.get(clazz, id);
        session.close();
        return item;
    }
    public List<T> findAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<T> items = (List<T>) session.createQuery("from " + clazz.getName()).list();
        session.close();
        return items;
    }
}
