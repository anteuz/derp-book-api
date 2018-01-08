package io.swagger.model.dao;
import org.springframework.data.repository.CrudRepository;

import io.swagger.model.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

}