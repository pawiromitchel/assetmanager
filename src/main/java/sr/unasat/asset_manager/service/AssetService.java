package sr.unasat.asset_manager.service;

import sr.unasat.asset_manager.dao.AssetDAO;
import sr.unasat.asset_manager.entity.Asset;

import javax.persistence.EntityManager;
import java.util.List;

public class AssetService {
    private AssetDAO assetDAO;
    private List<Asset> assetList;

    public AssetService(EntityManager entityManager) {
        assetDAO = new AssetDAO(entityManager);
        assetList = findAll();
    }

    public List<Asset> findAll(){
        return assetDAO.findAll();
    }

    public Asset findOne(long assetId){
        return assetDAO.findOne(assetId);
    }

    public  Asset create(Asset asset){
        return assetDAO.create(asset);
    }

    public  Asset update(Asset asset){
        return assetDAO.update(asset);
    }

    public  Asset delete(long id){
        Asset asset = findOne(id);
        return assetDAO.delete(asset);
    }
}
