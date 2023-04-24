package Spring.lesson4.Task2.persistence.dao.services.implementation;

import Spring.lesson4.Task2.persistence.dao.repositories.EmployeeRepositories;
import Spring.lesson4.Task2.persistence.dao.services.interfaces.EmployeeServices;
import Spring.lesson4.Task2.persistence.models.Employee;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    private EmployeeRepositories employeeRepositories;
    @Override
    public List<Employee> findAll() {
        if (employeeRepositories != null){
            List<Employee> employees = Lists.newArrayList(employeeRepositories.findAll());
            System.out.println(employees.size());
            return employees;
        }
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try{
            if (employeeRepositories != null){
                return employeeRepositories.save(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        employeeRepositories.deleteEmployeeById(id);
    }

    @Override
    public void listAllEmployee() {
        employeeRepositories.findAll().forEach(elem -> System.out.println(elem.getId()));
    }

    @Override
    public void updateEmployeeById(long id, String position) {
        employeeRepositories.updateEmployeeById(id, position);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepositories.findAllByName(name);
    }

    @Override
    public List<Employee> findAllByNameAndPosition(String name, String position) {
        return employeeRepositories.findAllByNameAndPosition(name,position);
    }
}
