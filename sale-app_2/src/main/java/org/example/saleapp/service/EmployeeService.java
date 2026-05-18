package org.example.saleapp.service;

import org.example.saleapp.model.Employee;
import org.example.saleapp.repository.EmployeeDao;
import java.util.List;
public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();
    public EmployeeService() {
    }
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
    public Employee findOne(final long id) {
        return employeeDao.findOne(id);
    }
    public void save(final Employee entity)
    {
        if (entity == null)
            return;
        employeeDao.save(entity);
    }
    public void update(final Employee entity)
    {
        if (entity == null)
            return;
        employeeDao.update(entity);
    }
    public void delete(final Employee entity)
    {
        if (entity == null)
            return;
        employeeDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        employeeDao.deleteById(id);
    }
}