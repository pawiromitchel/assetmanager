package sr.unasat.asset_manager.dao;

import sr.unasat.asset_manager.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO {
    private EntityManager entityManager;
    private List<Category> list;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        list = findAll();
    }

    public List<Category> findAll(){
        entityManager.getTransaction().begin();
        String jpql = "select e from Category e";
        TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
        list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }
}
