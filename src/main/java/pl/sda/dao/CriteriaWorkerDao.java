package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pl.sda.dto.Worker;
import pl.sda.util.HibernateUtil;

import java.util.List;

public class CriteriaWorkerDao implements WorkerDao {


    @Override
    public List<Worker> getAllWorkes() {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createCriteria(Worker.class)
                    .list();
        }
    }

    @Override
    public List<Worker> getWorkers(Worker filter) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createCriteria(Worker.class)
                    .add(Restrictions.like("firstName", filter.getFirstName()))
                    .add(Restrictions.like("LastName", filter.getLastName()))
                    .list();



        }
    }


    @Override
    public long countWorkers(){

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Long) session.createQuery("select count(w) from Worker w").getSingleResult();
        }

    }

    @Override
    public Worker getWorker(long idWorker) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(Worker.class, idWorker);
        }


    }

    @Override
    public void deleteWorker(long workerId) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Worker worker = session.get(Worker.class, workerId);
        session.delete(worker);

        tx.commit();
        session.close();


    }

    @Override
    public void saveWorker(Worker worker) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(worker);

        tx.commit();
        session.close();


    }

    @Override
    public void updateWorker(Worker worker) {

    }
}
