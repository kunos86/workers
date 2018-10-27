package pl.sda.dao;

import pl.sda.dto.Worker;

import java.util.List;

public interface WorkerDao {

    List<Worker> getAllWorkes();

    Worker getWorker(int idWorker);

    void deleteWorker(int workerId);

    void saveWorker(Worker worker);

    void updateWorker(Worker worker);




}