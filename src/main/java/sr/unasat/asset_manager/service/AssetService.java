package sr.unasat.asset_manager.service;

import sr.unasat.asset_manager.dao.AssetDAO;
import sr.unasat.asset_manager.entity.Asset;

import javax.persistence.EntityManager;
import java.util.List;

public class AssetService {
    private AssetDAO eassetDAO;
    private List<Asset> eassetList;

    public AssetService(EntityManager entityManager) {
        eassetDAO = new AssetDAO(entityManager);
        eassetList = findAll();
    }

    public List<Asset> findAll(){
        return eassetDAO.findAll();
    }
}
