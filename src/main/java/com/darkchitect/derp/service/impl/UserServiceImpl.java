package com.darkchitect.derp.service.impl;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.darkchitect.derp.config.Roles;
import com.darkchitect.derp.model.RoleEntity;
import com.darkchitect.derp.model.UserEntity;
import com.darkchitect.derp.model.dao.RoleRepository;
import com.darkchitect.derp.model.dao.UserRepository;
import com.darkchitect.derp.service.UserService;
import com.darkchitect.derp.service.shared.RegisterUserInit;


@Service(value = UserServiceImpl.NAME)
public class UserServiceImpl implements UserService {

	public final static String NAME = "UserService";
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userDao;

	@Autowired
	private RoleRepository roleRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = userDao.findByUsername(username);
		if (userDetails == null)
			return null;

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (GrantedAuthority role : userDetails.getAuthorities()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		return new org.springframework.security.core.userdetails.User(userDetails.getUsername(),
				userDetails.getPassword(), userDetails.getAuthorities());
	}

	@Override
	@Transactional
	@Secured(value = Roles.ROLE_ANONYMOUS)
	public UserEntity registerUser(RegisterUserInit init) {

		UserEntity userLoaded = userDao.findByUsername(init.getUserName());

		if (userLoaded == null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUsername(init.getUserName());
			userEntity.setEmail(init.getEmail());

			userEntity.setAuthorities(getUserRoles());
			userEntity.setPassword(UUID.randomUUID().toString());
			userDao.save(userEntity);
			
			logger.info("registerUser -> user created");
			return userEntity;
		} else {
			logger.info("registerUser -> user exists");
			return userLoaded;
		}
	}

	private List<RoleEntity> getAdminRoles() {
		return Collections.singletonList(getRole(Roles.ROLE_ADMIN));
	}

	private List<RoleEntity> getUserRoles() {
		return Collections.singletonList(getRole(Roles.ROLE_USER));
	}

	/**
	 * Get or create role
	 * @param authority
	 * @return
	 */
	private RoleEntity getRole(String authority) {
		RoleEntity adminRole = roleRepository.findByAuthority(authority);
		if (adminRole == null) {
			return new RoleEntity(authority);
		} else {
			return adminRole;
		}
	}

}