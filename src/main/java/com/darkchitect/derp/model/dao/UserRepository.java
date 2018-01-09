package com.darkchitect.derp.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.darkchitect.derp.model.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

}