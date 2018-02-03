package pl.sda.dto;

public class Worker {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
    private Integer birthYear;

    public Worker() {
    }


    public Worker(Integer id, String firstName, String lastName, String position, Integer salary, Integer birthYear) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (id != null ? !id.equals(worker.id) : worker.id != null) return false;
        if (firstName != null ? !firstName.equals(worker.firstName) : worker.firstName != null) return false;
        if (lastName != null ? !lastName.equals(worker.lastName) : worker.lastName != null) return false;
        if (position != null ? !position.equals(worker.position) : worker.position != null) return false;
        if (salary != null ? !salary.equals(worker.salary) : worker.salary != null) return false;
        return birthYear != null ? birthYear.equals(worker.birthYear) : worker.birthYear == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        return result;
    }
}
