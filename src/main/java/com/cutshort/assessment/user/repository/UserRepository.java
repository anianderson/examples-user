package com.cutshort.assessment.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cutshort.assessment.user.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	public User findByUsernameAndPassword(String username, String password);

	public User findByEmailAndPassword(String email, String password);

}
