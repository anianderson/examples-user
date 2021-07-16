package com.cutshort.assessment.user.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cutshort.assessment.user.entity.User;
import com.cutshort.assessment.user.model.LoginCredentials;

public interface UserService {

	List<User> findAll(Pageable pageable);

	User findById(Integer id);

	User findByUsernameAndPassword(String username, String password);

	User findByEmailAndPassword(String email, String password);

	User save(User user);

	void delete(Integer id);

	Boolean authenticate(LoginCredentials loginCredentials);

}
