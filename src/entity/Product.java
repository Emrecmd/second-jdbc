package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Product {
    long id;
    String name;
    LocalDateTime createdAt;
    long categoryId;

    public Product() {
    }

    public Product(long id, String name, LocalDateTime createdAt, long categoryId) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
