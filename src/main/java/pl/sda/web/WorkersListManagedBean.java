package pl.sda.web;


import pl.sda.dao.WorkerCriteriaDao;
import pl.sda.dao.WorkerDao;
import pl.sda.dao.WorkerJpqlDao;
import pl.sda.dto.Task;
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
    private Worker editWorker = new Worker();

    private Task newTask = new Task();

    private String filterValue = "";

    private WorkerDao workerDao = new WorkerJpqlDao();


    public List<Worker> getList() {


        return filterValue.isEmpty() ? workerDao.getAllWorkes() : workerDao.getByFilter(filterValue);
    }

    public void addNewWorker() {
        // dodać pracownika do bazy

        workerDao.saveWorker(newWorker);


        newWorker = new Worker();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }

    public void editWorker(Long id) {
        editWorker = workerDao.getWorker(id);
    }

    public void addNewTask() {

        if (editWorker.getTasks().size() >= 5) {
            editWorker.getTasks().remove(0);
        }
        newTask.setWorker(editWorker);
        editWorker.getTasks().add(newTask);

        workerDao.updateWorker(editWorker);
        newTask = new Task();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy zadanie zostało dodane dodany!"));
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

    public Task getNewTask() {
        return newTask;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
