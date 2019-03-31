package sr.unasat.asset_manager.dao;

import sr.unasat.asset_manager.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO {
    private EntityManager entityManager;
    private List<Employee> list;

    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        list = findAll();
    }

    public List<Employee> findAll(){
        entityManager.getTransaction().begin();
        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    public Employee findOne(long id){
        entityManager.getTransaction().begin();
        String jpql = "select e from Employee e where e.employee_id = :id";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("id", id);
        Employee foundRecord = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundRecord;
    }

    public Employee authenticate(Employee employee){
        entityManager.getTransaction().begin();
        String jpql = "select e from Employee e where e.username = :username and e.password = :password";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("username", employee.getUsername());
        query.setParameter("password", employee.getPassword());
        Employee foundRecord = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundRecord;
    }

    public Employee update(Employee employee){
        return employee;
    }

    public Employee delete(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        return employee;
    }
}
