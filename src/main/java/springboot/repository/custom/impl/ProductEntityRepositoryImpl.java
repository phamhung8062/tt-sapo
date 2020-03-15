package springboot.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springboot.repository.custom.ProductEntityRepositoryCustom;

@Repository
public class ProductEntityRepositoryImpl implements ProductEntityRepositoryCustom {

	@PersistenceContext
	public EntityManager entityManager;

	/*@Override
	public void deleteListOptions(Long id) {
		String sql = "DELETE FROM options WHERE version_id=" + id + "";
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}

	@Override
	public void deleteListVerison(Long id) {
		String sql = "DELETE FROM versions WHERE product_id=" + id + "";
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}*/
}
