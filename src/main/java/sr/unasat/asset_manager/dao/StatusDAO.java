package sr.unasat.asset_manager.dao;

import sr.unasat.asset_manager.entity.Status;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StatusDAO {

    private EntityManager entityManager;
    private List<Status> list;

    public StatusDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        list = findAll();
    }
    
    public List<Status> findAll(){
        entityManager.getTransaction().begin();
        String jpql = "select e from Status e";
        TypedQuery<Status> query = entityManager.createQuery(jpql, Status.class);
        list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    public Status findOne(long id){
        entityManager.getTransaction().begin();
        String jpql = "select e from Status e where e.statusId = :id";
        TypedQuery<Status> query = entityManager.createQuery(jpql, Status.class);
        query.setParameter("id", id);
        Status foundRecord = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundRecord;
    }
}
