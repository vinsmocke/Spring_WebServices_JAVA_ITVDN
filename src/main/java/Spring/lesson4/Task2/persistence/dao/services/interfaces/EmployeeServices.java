package Spring.lesson4.Task2.persistence.dao.services.interfaces;

import Spring.lesson4.Task2.persistence.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServices {
    List<Employee> findAll();

    Employee addEmployee(Employee employee);

    void removeById(long id);
    void listAllEmployee();
    void updateEmployeeById(long id, String position);

    List<Employee> findAllByName(String name);
    List<Employee> findAllByNameAndPosition(String name, String position);
}
