package pl.sda.web;


import pl.sda.dto.Employee;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SessionScoped
@ManagedBean(name = "employeeList")
public class EmployeesManagedBean {

    private List<Employee> employees = new ArrayList<>();
    private Employee newEmployee = new Employee();

    @PostConstruct
    public void init() {
        //TODO: usunąć po przepięciu na bazę
        employees.add(new Employee(1L,"Jan", "Kowalski", "Developer", 5000, 1985));
    }


    public List<Employee> getList() {
        //TODO: wczytać pracowników z bazy
        return employees;
    }

    public void addNewEmployee() {
        // dodać pracownika do bazy
        newEmployee.setId((new Random()).nextLong());
        employees.add(newEmployee);
        newEmployee = new Employee();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nowy pracownik został dodany!"));
    }


    public void deleteEmployee(long id) {
        // dodać usuwanie do bazy
        employees.removeIf(x -> x.getId() == id);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Pracownik został usunięty!"));
    }



    public Employee getNewEmployee() {
        return newEmployee;
    }
}
