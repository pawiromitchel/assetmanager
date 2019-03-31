package sr.unasat.asset_manager.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private long assetId;

    @Column(name = "asset_description")
    private String assetDescription;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "estimated_lifespan")
    private String estimatedLifespan;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "created_by")
    Employee createdByEmployee;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    Employee updatedByEmployee;

    public Asset() {
    }

    public Asset(long assetId, String assetDescription, String macAddress, String serialNumber, String estimatedLifespan, Status status, Category category, Employee createdByEmployee, Employee updatedByEmployee) {
        this.assetId = assetId;
        this.assetDescription = assetDescription;
        this.macAddress = macAddress;
        this.serialNumber = serialNumber;
        this.estimatedLifespan = estimatedLifespan;
        this.status = status;
        this.category = category;
        this.createdByEmployee = createdByEmployee;
        this.updatedByEmployee = updatedByEmployee;
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

    public Employee getCreatedByEmployee() {
        return createdByEmployee;
    }

    public void setCreatedByEmployee(Employee createdByEmployee) {
        this.createdByEmployee = createdByEmployee;
    }

    public Employee getUpdatedByEmployee() {
        return updatedByEmployee;
    }

    public void setUpdatedByEmployee(Employee updatedByEmployee) {
        this.updatedByEmployee = updatedByEmployee;
    }
}
