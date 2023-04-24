package Spring.lesson4.Task1.dao;

import Spring.lesson4.Task1.Connect.Connector;
import Spring.lesson4.Task1.models.Employee;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int PEOPLE_COUNT;
    private static Connection connection;

    private static final Connector connector = new Connector();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver load success");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(connector.url(), connector.login(), connector.password());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Employee> index(){
        List<Employee> employees = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPosition(resultSet.getString("position"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public Employee show(int id){
        Employee employee = null;

        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Employees WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPosition(resultSet.getString("position"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public void save(Employee employee){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Employees(name, surname, phone, email, position) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPosition());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Employee employee){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "UPDATE Employees SET name = ?, surname = ?, phone = ?, email = ?, position = ? WHERE id = ?");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Employees WHERE id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
