package pl.sda.web;


import pl.sda.dao.WorkersDAO;
import pl.sda.dto.Worker;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean(name = "workerList")
public class WorkersListManagedBean {

    private Worker newWorker = new Worker();
    private WorkersDAO workersDAO = new WorkersDAO();




    public List<Worker> getList() {
        return workersDAO.getAllWorkes();
    }

    public void addNewWorker() {
        // dodać pracownika do bazy

        workersDAO.saveWorker(newWorker);

        newWorker = new Worker();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }


    public void deleteWorker(int id) {
        // dodać pracownika do bazy
        workersDAO.deleteWorker(id);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Usunięto pracownika z id: " + id));
    }


    public Worker getNewWorker() {
        return newWorker;
    }


}
