package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.GiochiEntity;

public interface GiocoRepository extends CrudRepository<GiochiEntity, Long> {

}
