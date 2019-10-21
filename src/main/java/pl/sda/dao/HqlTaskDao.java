package pl.sda.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.dto.Task;
import pl.sda.dto.Worker;
import pl.sda.util.HibernateUtil;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class HqlTaskDao {


    public void test() {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Worker w = new Worker();
            w.setStartDate(Calendar.getInstance().getTime());
            w.setFirstName("Jan");
            w.setLastName("Testowy 111");
            w.setSalary(2000);
            w.setBirthYear(1995);
            Set<Task> tasks = new HashSet<>();
            w.setTasks(tasks);


            Task task = new Task();
            task.setDescription("test1");
            task.setEstimatedTime("3h");
            task.setWorker(w);
            tasks.add(task);


            Task task2 = new Task();
            task2.setDescription("test2");
            task2.setEstimatedTime("3h");
            task2.setWorker(w);
            tasks.add(task2);

            session.save(w);

            tx.commit();
        }


    }


}
