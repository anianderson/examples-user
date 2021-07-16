package com.cutshort.assessment.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cutshort.assessment.user.entity.User;
import com.cutshort.assessment.user.model.LoginCredentials;
import com.cutshort.assessment.user.repository.UserRepository;
import com.cutshort.assessment.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll(Pageable pageable) {
		Page<User> page = userRepository.findAll(pageable);
		return page.getContent();
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public Boolean authenticate(LoginCredentials loginCredentials) {
		return userRepository.findByEmailAndPassword(loginCredentials.getUser(), loginCredentials.getPassword()) != null
				|| userRepository.findByUsernameAndPassword(loginCredentials.getUser(),
						loginCredentials.getPassword()) != null;
	}

}
