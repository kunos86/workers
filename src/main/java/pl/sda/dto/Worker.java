package pl.sda.dto;

import java.util.Objects;

public class Worker {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
    private Integer birthYear;

    public Worker() {
    }

    public Worker(Long id, String firstName, String lastName, String position, Integer salary, Integer birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(firstName, worker.firstName) &&
                Objects.equals(lastName, worker.lastName) &&
                Objects.equals(position, worker.position) &&
                Objects.equals(salary, worker.salary) &&
                Objects.equals(birthYear, worker.birthYear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, position, salary, birthYear);
    }
}
