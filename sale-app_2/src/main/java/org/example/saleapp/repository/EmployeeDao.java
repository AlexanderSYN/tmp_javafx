package org.example.saleapp.repository;
import org.example.saleapp.model.Employee;
public class EmployeeDao extends BaseDao<Employee> {
    public EmployeeDao() {
        super(Employee.class);
    }
}