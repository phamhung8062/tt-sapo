package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
