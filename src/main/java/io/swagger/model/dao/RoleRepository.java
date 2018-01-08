package io.swagger.model.dao;
import org.springframework.data.repository.CrudRepository;

import io.swagger.model.RoleEntity;


public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

	RoleEntity findByAuthority(String authority);
}