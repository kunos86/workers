package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import pl.sda.dto.Worker;
import pl.sda.util.HibernateUtil;

import java.util.List;

public class HqlWorkerDao implements WorkerDao {


    @Override
    public List<Worker> getAllWorkes() {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("from Worker").list();


        }
    }

    @Override
    public List<Worker> getWorkers(Worker filter) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("from Worker w WHERE w.firstName like :firstName and w.lastName like :lastName")
                    .setParameter("firstName", filter.getFirstName() + "%")
                    .setParameter("lastName", filter.getLastName() + "%")
                    .list();


        }
    }


    @Override
    public long countWorkers() {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return (Long) session.createCriteria(Worker.class).setProjection(Projections.rowCount()).uniqueResult();

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
