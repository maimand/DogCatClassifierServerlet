package model.Bean;

public class History {
    String imageUrl;
    String description;
    String userId;


    public History(String imageUrl, String description, String userId) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "History{" +
                "imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
