package sr.unasat.asset_manager.builders;

import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.entity.Category;
import sr.unasat.asset_manager.entity.Employee;
import sr.unasat.asset_manager.entity.Status;

public class AssetBuilder implements Builder{
    private long assetId;
    private String assetDescription;
    private String macAddress;
    private String serialNumber;
    private String estimatedLifespan;
    private Status status;
    private Category category;
    private Employee createdByEmployee;
    private Employee updatedByEmployee;

    public Asset getResult(){
        return new Asset(assetId, assetDescription, macAddress, serialNumber, estimatedLifespan, status, category, createdByEmployee, updatedByEmployee);
    }

    @Override
    public void setAssetId(long assetId){
        this.assetId = assetId;
    }

    @Override
    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    @Override
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public void setEstimatedLifespan(String estimatedLifespan) {
        this.estimatedLifespan = estimatedLifespan;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void setCreatedByEmployee(Employee createdByEmployee) {
        this.createdByEmployee = createdByEmployee;
    }

    @Override
    public void setUpdatedByEmployee(Employee updatedByEmployee) {
        this.updatedByEmployee = updatedByEmployee;
    }
}
