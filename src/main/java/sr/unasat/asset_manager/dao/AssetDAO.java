package sr.unasat.asset_manager.dao;

import sr.unasat.asset_manager.entity.Asset;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AssetDAO {
    private EntityManager entityManager;
    private List<Asset> list;

    public AssetDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        list = findAll();
    }

    public List<Asset> findAll(){
        entityManager.getTransaction().begin();
        String jpql = "select e from Asset e";
        TypedQuery<Asset> query = entityManager.createQuery(jpql, Asset.class);
        list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    public Asset create(Asset asset){
        entityManager.getTransaction().begin();
        entityManager.persist(asset);
        entityManager.getTransaction().commit();
        return asset;
    }

    public Asset findOne(long id){
        entityManager.getTransaction().begin();
        String jpql = "select e from Asset e where e.assetId = :id";
        TypedQuery<Asset> query = entityManager.createQuery(jpql, Asset.class);
        query.setParameter("id", id);
        Asset foundRecord = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundRecord;
    }

    public Asset update(Asset asset){
        entityManager.getTransaction().begin();
        entityManager.merge(asset);
        entityManager.getTransaction().commit();
        return asset;
    }

    public Asset delete(Asset Asset){
        entityManager.getTransaction().begin();
        entityManager.remove(Asset);
        entityManager.getTransaction().commit();
        return Asset;
    }
}
