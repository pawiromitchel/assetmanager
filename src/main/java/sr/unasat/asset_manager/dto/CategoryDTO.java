package sr.unasat.asset_manager.dto;

public class CategoryDTO {
    private long categoryId;
    private String name;

    public CategoryDTO(long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public CategoryDTO() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
