package com.food.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.food.model.CurrentUserSession;



public interface CurrentUserSessionRepo extends JpaRepositoryImplementation<CurrentUserSession, Integer>
{
	public CurrentUserSession findByEmail(String email);
	
	public CurrentUserSession findByPrivateKey(String key);

}

