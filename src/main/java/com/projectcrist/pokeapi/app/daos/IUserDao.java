package com.projectcrist.pokeapi.app.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectcrist.pokeapi.app.models.Users;

@Repository
public interface IUserDao extends CrudRepository<Users, Long>{
	
	
	@Query(nativeQuery = true,value = "SELECT * FROM USER WHERE USER_EMAIL = ? ")
	public Users findUserByEmail(String Email);

}
