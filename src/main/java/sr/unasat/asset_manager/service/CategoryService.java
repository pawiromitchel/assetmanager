package sr.unasat.asset_manager.service;

import sr.unasat.asset_manager.dao.CategoryDAO;
import sr.unasat.asset_manager.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryService {
        private CategoryDAO assetDAO;
        private List<Category> assetList;

        public CategoryService(EntityManager entityManager) {
            assetDAO = new CategoryDAO(entityManager);
            assetList = findAll();
        }

        public List<Category> findAll(){
            return assetDAO.findAll();
        }
}
