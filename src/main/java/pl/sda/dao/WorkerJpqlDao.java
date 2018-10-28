package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.sda.dto.Worker;

import java.util.List;

public class WorkerJpqlDao implements WorkerDao{

    private SessionFactory sessionFactory;

    public WorkerJpqlDao(){
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }



    @Override
    public List<Worker> getAllWorkes() {
        List<Worker> workers;
        Session session = sessionFactory.openSession();
        workers = session.createNamedQuery("getAll", Worker.class).getResultList();
        session.close();
        return workers;
    }

    @Override
    public Worker getWorker(long idWorker) {
        return null;
    }

    @Override
    public void deleteWorker(long workerId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Worker workerToDelete = session.get( Worker.class, workerId);

        session.delete(workerToDelete);
        tx.commit();
        session.close();
    }

    @Override
    public void saveWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(worker);

        tx.commit();
        session.close();
    }

    @Override
    public void updateWorker(Worker worker) {

    }

    @Override
    public List<Worker> getByLastName(String lastName) {
        List<Worker> workers;
        Session session = sessionFactory.openSession();
        workers = session.createQuery("from Worker where lastName = :lastName")
                .setParameter("lastName",lastName )

                .getResultList();
        session.close();
        return workers;
    }
}
