package springboot.repository.custom;

import springboot.entity.ProductEntity;

public interface ProductEntityRepositoryCustom{
   void deleteListOptions(Long id);
   ProductEntity findVersion(String name);
}
