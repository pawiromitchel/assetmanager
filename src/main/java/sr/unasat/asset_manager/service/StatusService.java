package sr.unasat.asset_manager.service;

import sr.unasat.asset_manager.dao.StatusDAO;
import sr.unasat.asset_manager.entity.Status;

import javax.persistence.EntityManager;
import java.util.List;

public class StatusService {
    private StatusDAO statusDAO;
    private List<Status> assetList;

    public StatusService(EntityManager entityManager) {
        statusDAO = new StatusDAO(entityManager);
        assetList = findAll();
    }

    public List<Status> findAll(){
        return statusDAO.findAll();
    }

    public Status findOne(long statusId){
        return statusDAO.findOne(statusId);
    }
}
