import java.util.List;

public interface EmployeeService {

    void add(Employee employee);

    List<Employee> findAll();

    Employee findById(Long id);

    boolean update(Long id, String name, String department, Double salary);

    boolean remove(Long id);
}