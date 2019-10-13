package pl.sda.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.dto.Worker;

import java.util.List;

public class HqlWorkerDaoTest {

    @Test
    public void testWorker() {
        Worker worker = new Worker();
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        worker.setBirthYear(1998);
        worker.setSalary(20000);

        HqlWorkerDao hqlWorkerDao = new HqlWorkerDao();


        hqlWorkerDao.saveWorker(worker);

        List<Worker> list = hqlWorkerDao.getAllWorkes();
        Assert.assertTrue(list.size() > 0);

        Long idNewAddedWorker = worker.getId();

        Worker workerFromDb = hqlWorkerDao.getWorker(idNewAddedWorker);

        Assert.assertEquals(worker.getLastName(), workerFromDb.getLastName());
        Assert.assertEquals(worker.getFirstName(), workerFromDb.getFirstName());


        hqlWorkerDao.deleteWorker(idNewAddedWorker);


    }
}