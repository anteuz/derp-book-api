package com.darkchitect.derp.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.darkchitect.derp.model.RoleEntity;


public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

	RoleEntity findByAuthority(String authority);
}