package sr.unasat.asset_manager.builders;

import sr.unasat.asset_manager.entity.Category;
import sr.unasat.asset_manager.entity.Employee;
import sr.unasat.asset_manager.entity.Status;

public interface Builder {
    void setAssetId(long assetId);
    void setAssetDescription(String assetDescription);
    void setMacAddress(String macAddress);
    void setSerialNumber(String serialNumber);
    void setEstimatedLifespan(String estimatedLifespan);
    void setStatus(Status status);
    void setCategory(Category category);
    void setCreatedByEmployee(Employee createdByEmployee);
    void setUpdatedByEmployee(Employee updatedByEmployee);
}
