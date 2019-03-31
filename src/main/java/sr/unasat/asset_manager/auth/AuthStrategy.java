package sr.unasat.asset_manager.auth;

import sr.unasat.asset_manager.entity.Employee;

public interface AuthStrategy {
    Employee auth(Employee employee);
}
