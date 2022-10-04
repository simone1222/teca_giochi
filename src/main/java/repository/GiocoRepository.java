package repository;

import org.springframework.data.repository.CrudRepository;

import model.GiochiEntity;

public interface GiocoRepository extends CrudRepository<GiochiEntity, Long> {

//    @Query("")
//    List<GiochiEntity> get
}
