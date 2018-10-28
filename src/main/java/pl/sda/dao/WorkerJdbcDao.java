package pl.sda.dao;

import pl.sda.dto.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerJdbcDao implements WorkerDao {


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/work", "dbuser", "dbpass");

    }


    @Override
    public List<Worker> getAllWorkes() {

        List<Worker> workers = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement("Select * from worker ");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Worker worker = new Worker(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("position"),
                rs.getInt("salary"),
                rs.getInt("birthYear"));
                workers.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    @Override
    public Worker getWorker(long idWorker) {
        return null;
    }

    @Override
    public void deleteWorker(long workerId) {

    }

    @Override
    public void saveWorker(Worker worker) {
        try (Connection conn = getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement("INSERT INTO worker (birthYear,first_name,last_name,position,salary) " +
                            "VALUES (?,?,?,?,?)");

            statement.setInt(1,worker.getBirthYear());
            statement.setString(2,worker.getFirstName());
            statement.setString(3,worker.getLastName());
            statement.setString(4,worker.getPosition());
            statement.setInt(5,worker.getSalary());


            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateWorker(Worker worker) {

    }

    @Override
    public List<Worker> getByLastName(String lastName) {
        return null;
    }
}
