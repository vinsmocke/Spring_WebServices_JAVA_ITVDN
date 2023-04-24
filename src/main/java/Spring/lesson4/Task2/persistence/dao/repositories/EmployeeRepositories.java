package Spring.lesson4.Task2.persistence.dao.repositories;

import Spring.lesson4.Task2.persistence.models.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeRepositories  extends CrudRepository<Employee, Long> {

    List<Employee> findAllByName(String name);
    List<Employee> findAllByNameAndPosition(String name, String position);

    @Modifying
    @Query(value = "update employee set position = :position where id = :id", nativeQuery = true)
    void updateEmployeeById(long id, String position);

    @Modifying
    @Query(value = "delete from employee where id = :id", nativeQuery = true)
    void deleteEmployeeById(long id);
}
