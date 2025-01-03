package entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Category {
    private long id;
    private String name;
    private LocalDateTime createdAt;

    public Category() {
    }

    public Category(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
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
}
