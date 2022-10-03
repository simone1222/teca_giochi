package service;

import java.util.List;
import java.util.Optional;

import model.GiochiEntity;
import repository.GiocoRepository;

public class GiocoService implements GiocoRepository {

	GiocoRepository repo;
	@Override
	public <S extends GiochiEntity> S save(S entity) {
		return null;
	}

	@Override
	public <S extends GiochiEntity> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<GiochiEntity> findById(Long id) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public Iterable<GiochiEntity> findAll() {
		return null;
	}

	@Override
	public Iterable<GiochiEntity> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(GiochiEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends GiochiEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
//
//	@Override
//	public List<GiochiEntity> searchGame(String game) {
//		repo.searchGame(game);
//		return null;
//	}

}
