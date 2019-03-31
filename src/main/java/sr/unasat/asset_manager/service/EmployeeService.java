package sr.unasat.asset_manager.service;

import sr.unasat.asset_manager.dao.EmployeeDAO;
import sr.unasat.asset_manager.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    private List<Employee> employeeList;

    public EmployeeService(EntityManager entityManager) {
        employeeDAO = new EmployeeDAO(entityManager);
        employeeList = findAll();
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    public Employee authenticate(Employee employee){
        Employee foundRecord = employeeDAO.authenticate(employee);
        return foundRecord;
    }
}
