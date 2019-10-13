package pl.sda.web;


import pl.sda.dao.HqlWorkerDao;
import pl.sda.dao.WorkerDao;
import pl.sda.dto.Worker;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@SessionScoped
@ManagedBean(name = "workerList")
public class WorkersListManagedBean {

    private Worker newWorker = new Worker();
    private WorkerDao workerDao = new HqlWorkerDao();


    public List<Worker> getList() {
        return workerDao.getAllWorkes();
    }

    public long getCount() {
        return workerDao.countWorkers();
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
