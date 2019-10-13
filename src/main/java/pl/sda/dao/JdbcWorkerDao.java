package pl.sda.dao;

import pl.sda.dto.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcWorkerDao implements WorkerDao {

    @Override
    public List<Worker> getAllWorkes() {
        List<Worker> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers",
                "dbuser", "dbpass")) {

            PreparedStatement statement = connection.prepareStatement("Select * from worker");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Worker w = new Worker();
                w.setId(rs.getLong("id"));
                w.setFirstName(rs.getString("first_name"));
                w.setLastName(rs.getString("last_name"));
                w.setPosition(rs.getString("position"));
                w.setSalary(rs.getInt("salary"));
                w.setBirthYear(rs.getInt("birthYear"));
                list.add(w);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Worker> getWorkers(Worker filter) {
        return null;
    }

    @Override
    public long countWorkers() {
        long count = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers",
                "dbuser", "dbpass")) {
            PreparedStatement statement = connection.prepareStatement("Select count(*) as licznik from worker");
           ResultSet rs =  statement.executeQuery();

           while (rs.next()){
               count = rs.getLong(1);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers",
                "dbuser", "dbpass")) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `worker`" +
                    "(`birthYear`,`first_name`,`last_name`,`position`,`salary`) " +
                    "VALUES (?,?,?,?,?)");

            statement.setInt(1, worker.getBirthYear());
            statement.setString(2, worker.getFirstName());
            statement.setString(3, worker.getLastName());
            statement.setString(4, worker.getPosition());
            statement.setInt(5, worker.getSalary());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateWorker(Worker worker) {

    }
}
