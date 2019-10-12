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
    public Worker getWorker(long idWorker) {
        return null;
    }

    @Override
    public void deleteWorker(long workerId) {

    }

    @Override
    public void saveWorker(Worker worker) {

    }

    @Override
    public void updateWorker(Worker worker) {

    }
}
