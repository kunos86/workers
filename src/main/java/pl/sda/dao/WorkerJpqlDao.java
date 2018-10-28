package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.sda.dto.Task;
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
//        workers = session.createNamedQuery("getAll", Worker.class).getResultList();
        workers = session.createQuery("from Worker", Worker.class).getResultList();
        session.close();
        return workers;
    }

    @Override
    public Worker getWorker(long idWorker) {
        Worker workers;
        Session session = sessionFactory.openSession();
        workers = session.get(Worker.class, idWorker);
        session.close();
        return workers;
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
    public void saveTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        session.save(task);

        tx.commit();
        session.close();
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(worker);
        tx.commit();
        session.close();
    }

    @Override
    public List<Worker> getByFilter(String filter) {
        List<Worker> workers;


        Session session = sessionFactory.openSession();
        workers = session.createNamedQuery("getByFilter", Worker.class)
                .setParameter("filter","%"+filter + "%")
                .getResultList();
        session.close();
        return workers;
    }
}
