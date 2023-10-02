package quarkus.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Funcionalidade {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String nome;

    @Column
    public String descricao;

    @Column
    public String uuid;


    public Funcionalidade() {

        this.uuid = UUID.randomUUID().toString();
    }


}
