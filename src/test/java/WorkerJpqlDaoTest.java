import org.junit.Assert;
import org.junit.Test;
import pl.sda.dao.WorkerDao;
import pl.sda.dao.WorkerJdbcDao;
import pl.sda.dao.WorkerJpqlDao;
import pl.sda.dto.Worker;

import java.util.List;

public class WorkerJpqlDaoTest {


    @Test
    public void getAllWorkerTest(){
        WorkerDao workerDao = new WorkerJpqlDao();
        List<Worker> workers = workerDao.getAllWorkes();
        Assert.assertTrue(workers.size()>0);


    }


}
