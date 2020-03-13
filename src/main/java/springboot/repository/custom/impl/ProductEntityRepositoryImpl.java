package springboot.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springboot.entity.ProductEntity;
import springboot.repository.custom.ProductEntityRepositoryCustom;

@Repository
public class ProductEntityRepositoryImpl implements ProductEntityRepositoryCustom{

	@PersistenceContext
	public EntityManager entityManager;
	@Override
	public void deleteListOptions(Long id) {
		String sql="DELETE FROM options WHERE product_id=" +id+ "";
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
		
	}
	@Override
	public ProductEntity findVersion(String name) {
		String sql=" Select * from product inner join versions on product.version_id=version.id ";
		sql+=" inner join options on product.id=options.product_id  Where versions.version_name=";
		return null;
	}

}
