package sr.unasat.asset_manager.auth;

import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.entity.Employee;
import sr.unasat.asset_manager.service.EmployeeService;

public class AuthWithMySQL implements AuthStrategy{
    @Override
    public Employee auth(Employee employee) {
        EmployeeService employeeService = new EmployeeService(JPAConfiguration.getEntityManager());
        return employeeService.authenticate(employee);
    }
}
