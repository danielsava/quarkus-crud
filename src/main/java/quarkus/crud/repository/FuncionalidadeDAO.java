package quarkus.crud.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import quarkus.crud.entity.Funcionalidade;

import java.util.List;

@ApplicationScoped
public class FuncionalidadeDAO  implements PanacheRepository<Funcionalidade> {



    public Funcionalidade findByName(String name) {

        return find("name", name).firstResult();
    }


    public List<Funcionalidade> findByDescricao(String descricao) {

        return list("descricao", descricao);
    }

    public void deleteByUUID(String uuid) {

        delete("uuid", uuid);
    }


}

