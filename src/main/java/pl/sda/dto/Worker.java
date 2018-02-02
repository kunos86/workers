package pl.sda.dto;

public class Worker {
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
    private Integer birthYear;

    public Worker() {
    }


    public Worker(String firstName, String lastName, String position, Integer salary, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.birthYear = birthYear;
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

        if (salary != worker.salary) return false;
        if (birthYear != worker.birthYear) return false;
        if (firstName != null ? !firstName.equals(worker.firstName) : worker.firstName != null) return false;
        if (lastName != null ? !lastName.equals(worker.lastName) : worker.lastName != null) return false;
        return position != null ? position.equals(worker.position) : worker.position == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + birthYear;
        return result;
    }
}
