package com.maiamateus.btcprojectback.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.maiamateus.btcprojectback.domain.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	public ClientDTO() {
	}

	public ClientDTO(Client obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
