package pl.sda.dao;

import pl.sda.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    Employee get(int employeeId);

    void delete(int employeeId);

    void save(Employee employee);

    void update(Employee employee);




}