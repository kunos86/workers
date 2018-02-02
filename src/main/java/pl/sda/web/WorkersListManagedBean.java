package pl.sda.web;


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

    private List<Worker> workers = new ArrayList<>();
    private Worker newWorker = new Worker();

    @PostConstruct
    public void init() {
        //TODO: usunąć po przepięciu na bazę
        workers.add(new Worker("Jan", "Kowalski", "Developer", 5000, 1985));
    }


    public List<Worker> getList() {
        //TODO: wczytać pracowników z bazy
        return workers;
    }

    public void addNewWorker() {
        // dodać pracownika do bazy

        workers.add(newWorker);
        newWorker = new Worker();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }


    public Worker getNewWorker() {
        return newWorker;
    }
}
