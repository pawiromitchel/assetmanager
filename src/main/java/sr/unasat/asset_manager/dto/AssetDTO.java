package sr.unasat.asset_manager.dto;

import sr.unasat.asset_manager.entity.Category;
import sr.unasat.asset_manager.entity.Status;

public class AssetDTO {
    private long assetId;
    private String assetDescription;
    private String macAddress;
    private String serialNumber;
    private String estimatedLifespan;
    private Status status;
    private Category category;

    public AssetDTO() {
    }

    public AssetDTO(long assetId, String assetDescription, String macAddress, String serialNumber, String estimatedLifespan, Status status, Category category) {
        this.assetId = assetId;
        this.assetDescription = assetDescription;
        this.macAddress = macAddress;
        this.serialNumber = serialNumber;
        this.estimatedLifespan = estimatedLifespan;
        this.status = status;
        this.category = category;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEstimatedLifespan() {
        return estimatedLifespan;
    }

    public void setEstimatedLifespan(String estimatedLifespan) {
        this.estimatedLifespan = estimatedLifespan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
