package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.VersionEntity;

public interface VersionEntityRepository  extends JpaRepository<VersionEntity, Long>{

}
