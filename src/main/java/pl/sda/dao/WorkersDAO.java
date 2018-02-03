package pl.sda.dao;

import pl.sda.dto.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkersDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/books?user=dbuser&password=dbpass");

    }


    public List<Worker> getAllWorkes() {
        List<Worker> workers = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConnection();

            PreparedStatement statement = conn.prepareStatement
                    ("Select * from workers ");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firsName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String position = rs.getString("position");
                int salary = rs.getInt("salary");
                int birthYear = rs.getInt("birthYear");
                Worker worker = new Worker();
                worker.setId(id);
                worker.setFirstName(firsName);
                worker.setLastName(lastName);
                worker.setPosition(position);
                worker.setSalary(salary);
                worker.setBirthYear(birthYear);
                workers.add(worker);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("wywaliło się na bazie");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }

        return workers;

    }

    public void deleteWorker(int workerId) {
        Connection conn = null;
        try {
            conn = getConnection();

            PreparedStatement statement = conn.prepareStatement
                    ("delete from workers where id = ?");

            statement.setInt(1, workerId);
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("wywaliło się na bazie");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }


    public void saveWorker(Worker worker) {

        Connection conn = null;
        try {
            conn = getConnection();

            PreparedStatement statement = conn.prepareStatement
                    ("INSERT INTO workers(first_name,last_name,position,salary,birthYear)VALUES (?,?,?,?,?) ");

            statement.setString(1, worker.getFirstName());
            statement.setString(2, worker.getLastName());
            statement.setString(3, worker.getPosition());
            statement.setInt(4, worker.getSalary());
            statement.setInt(5, worker.getBirthYear());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("wywaliło się na bazie");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }


    }


}
