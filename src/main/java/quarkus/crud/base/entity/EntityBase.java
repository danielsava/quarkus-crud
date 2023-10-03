package quarkus.crud.base.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class EntityBase extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    @Version
    public Long version;

    public LocalDateTime createAt;

    public LocalDateTime updateAt;


    @PrePersist
    void prePersist() {

        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {

        this.updateAt = LocalDateTime.now();
    }


    public EntityBase() { }

}
