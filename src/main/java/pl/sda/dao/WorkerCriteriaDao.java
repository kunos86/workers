package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import pl.sda.dto.Task;
import pl.sda.dto.Worker;

import java.util.List;

public class WorkerCriteriaDao implements WorkerDao{

    private SessionFactory sessionFactory;

    public WorkerCriteriaDao(){
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }



    @Override
    public List<Worker> getAllWorkes() {
        List<Worker> workers;
        Session session = sessionFactory.openSession();
        workers = session.createCriteria(Worker.class)
                .addOrder(Order.asc("lastName"))
                .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
                .list();
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
    public List<Worker> getByFilter(String filter) {
        List<Worker> workers;
        Session session = sessionFactory.openSession();
        workers = session.createCriteria(Worker.class).add(Restrictions.or(
                Restrictions.like("lastName", filter, MatchMode.ANYWHERE),
                Restrictions.like("firstName", filter, MatchMode.ANYWHERE),
                Restrictions.like("position", filter, MatchMode.ANYWHERE))).list();
        session.close();
        return workers;
    }

    @Override
    public void saveTask(Task task) {

    }
}
