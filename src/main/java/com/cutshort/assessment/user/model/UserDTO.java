package com.cutshort.assessment.user.model;

import com.cutshort.assessment.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private String email;

	public User toEntity() {
		return new User(id, username, password, email);
	}

}
