package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.GenereEntity;
import model.GiochiEntity;

public interface GiocoRepository extends CrudRepository<GiochiEntity, Long> {

    List<GiochiEntity> findByGenere(GenereEntity entity);
}
