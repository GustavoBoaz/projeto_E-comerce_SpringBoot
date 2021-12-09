package com.gees.App.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * "tb_users" table abstraction. This columns is:
 * 
 * <p>
 * - idUser: represents user id column. This column is automatically
 * generated and auto increment;
 * </p>
 * <p>
 * - rewards: represents user points column Float. This column is automatically
 * generated;
 * </p>
 * <p>
 * - name: represents user name column. String;
 * </p>
 * <p>
 * - email: represents user email column. String;
 * </p>
 * <p>
 * - password: represents user password column. String;
 * </p>
 * 
 * @author Boaz
 * @since 1.0
 * @see RequestModel
 * @see ProductModel
 * 
 */
@Entity
@Table(name = "tb_users")
public class UserModel {

	// System generated Value
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUser;
	private @SuppressWarnings("deprecation") Long rewards = new Long(0);

	// User generated Values
	private String name;
	private String email;
	private String password;

	// Relations
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE)
	private List<RequestModel> myRequests = new ArrayList<>();

	// Getters and Setters
	public Long getIdUser() {
		return idUser;
	}

	public List<RequestModel> getMyRequests() {
		return myRequests;
	}

	public void setMyRequests(List<RequestModel> myRequests) {
		this.myRequests = myRequests;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public Long getRewards() {
		return rewards;
	}

	public void setRewards(Long rewards) {
		this.rewards = rewards;
	}

}
