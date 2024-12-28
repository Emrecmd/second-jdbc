package entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Category {
    private long id;
    private String title;
    private LocalDateTime created;
    private Timestamp updated;

    public Category() {
    }

    public Category(String title, LocalDateTime created) {
        this.title = title;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
