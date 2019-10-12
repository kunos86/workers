package pl.sda.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.dto.Worker;

import java.util.List;

public class JdbcWorkerDaoTest {

    @Test
    public void testInsert() {
        WorkerDao workerDao = new JdbcWorkerDao();

        List<Worker> listBefore = workerDao.getAllWorkes();

        Worker worker = new Worker();
        worker.setFirstName("Jan");
        worker.setLastName("Nowak");
        worker.setBirthYear(1998);
        worker.setSalary(20000);


        workerDao.saveWorker(worker);
        List<Worker> listAfter = workerDao.getAllWorkes();

        Assert.assertEquals(listBefore.size() + 1, listAfter.size());

    }

}