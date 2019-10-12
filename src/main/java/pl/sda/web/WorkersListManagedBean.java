package pl.sda.web;


import pl.sda.dao.JdbcWorkerDao;
import pl.sda.dao.WorkerDao;
import pl.sda.dto.Worker;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SessionScoped
@ManagedBean(name = "workerList")
public class WorkersListManagedBean {

    private Worker newWorker = new Worker();
    private WorkerDao  workerDao = new JdbcWorkerDao();



    public List<Worker> getList() {
        //TODO: wczytać pracowników z bazy
        return workerDao.getAllWorkes();
    }

    public void addNewWorker() {
        // dodać pracownika do bazy

      workerDao.saveWorker(newWorker);

        newWorker = new Worker();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }


    public void deleteWorker(long id) {
        // dodać usuwanie do bazy

        workerDao.deleteWorker(id);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pracownik został usunięty!"));
    }



    public Worker getNewWorker() {
        return newWorker;
    }
}
