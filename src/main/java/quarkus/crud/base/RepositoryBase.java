package quarkus.crud.base;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 *      Join
 *       - SELECT g FROM ChessHame g LEFT JOIN FETCH g.playerWhite LEFT JOIN FETCH g.playerBlack WHERE g.playerBlack.nome = <nome>
 *
 *
 */

public abstract class RepositoryBase<E extends EntityBase> implements PanacheRepository<E> {


    public boolean existe(Long id) {

        return count("id", id) > 0;
    }


    public List<E> find(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return list("id = :id or nome = :nome or descricao = :desc", params);
    }


    public List<E> findContains(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return list("id = :id or nome like CONCAT('%', CONCAT(:nome, '%')) or descricao = :desc", params);
    }


    public List<E> findLastest() {

        return list("order by id DESC");
    }


}
