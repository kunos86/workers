package pl.sda.dao;

import pl.sda.dto.Task;
import pl.sda.dto.Worker;

import java.util.List;

public interface WorkerDao {

    List<Worker> getAllWorkes();

    List<Worker> getByFilter(String filter);

    Worker getWorker(long idWorker);

    void deleteWorker(long  workerId);

    void saveWorker(Worker worker);

    void saveTask(Task task);

    void updateWorker(Worker worker);






}