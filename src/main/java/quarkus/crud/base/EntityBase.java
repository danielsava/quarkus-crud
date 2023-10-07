package quarkus.crud.base;

import io.quarkus.logging.Log;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Version
    @Column(name = "version")
    public Long version;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;


    @PrePersist
    void prePersist() {

        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {

        this.updatedAt = LocalDateTime.now();
    }


    public EntityBase() { }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityBase that = (EntityBase) o;
        return Objects.equals(id, that.id) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }


    public Long getId() {

        Log.info("[EntityBase] Passou no GET do ID ...");

        return id;
    }


}
