package sr.unasat.asset_manager.dto;

public class StatusDTO {
    private long statusId;
    private String status;

    public StatusDTO(long statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public StatusDTO() {
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
