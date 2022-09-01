package doa.dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Employee getEmployeeByEmail(String email);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
