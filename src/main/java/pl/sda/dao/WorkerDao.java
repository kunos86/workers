package pl.sda.dao;

import pl.sda.dto.Worker;

import java.util.List;

public interface WorkerDao {

    List<Worker> getAllWorkes();

    List<Worker> getByLastName(String lastName);

    Worker getWorker(long idWorker);

    void deleteWorker(long  workerId);

    void saveWorker(Worker worker);

    void updateWorker(Worker worker);






}