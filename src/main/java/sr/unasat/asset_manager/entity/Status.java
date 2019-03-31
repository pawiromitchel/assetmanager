package sr.unasat.asset_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private long statusId;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "category")
    List<Asset> assetList;

    public Status() {
    }

    public Status(String status, List<Asset> assetList) {
        this.status = status;
        this.assetList = assetList;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
