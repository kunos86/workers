package pl.sda.web;


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

    private List<Worker> workers = new ArrayList<>();
    private Worker newWorker = new Worker();

    @PostConstruct
    public void init() {
        //TODO: usunąć po przepięciu na bazę
        workers.add(new Worker(1l,"Jan", "Kowalski", "Developer", 5000, 1985));
    }


    public List<Worker> getList() {
        //TODO: wczytać pracowników z bazy
        return workers;
    }

    public void addNewWorker() {
        // dodać pracownika do bazy
        newWorker.setId((new Random()).nextLong());
        workers.add(newWorker);
        newWorker = new Worker();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }


    public void deleteWorker(long id) {
        // dodać usuwanie do bazy
        workers.removeIf(x -> x.getId() == id);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pracownik został usunięty!"));
    }



    public Worker getNewWorker() {
        return newWorker;
    }
}
