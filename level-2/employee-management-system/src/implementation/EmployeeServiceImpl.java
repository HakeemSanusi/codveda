import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>(0);

    @Override
    public void add(Employee employee) {
        if (findById(employee.getId()) != null) {
            throw new IllegalArgumentException("Employee with this ID already exists.");
        }
        employees.add(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        if (employees.isEmpty()) {
            return null;
        }
        if (id <= 0) {
            return null;
        }
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst().orElse(null);
    }
   

    @Override
    public boolean update(Long id, String name, String department, Double salary) {
        Employee emp = findById(id);
        if (emp == null) {
            return false;
        }
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        return true;
    }

    @Override
    public boolean remove(Long id) {

        Employee emp = findById(id);
        if (emp == null) {
            return false;
        }
        employees.remove(emp);
        return true;
    }
}
