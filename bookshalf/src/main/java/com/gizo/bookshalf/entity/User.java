package com.gizo.bookshalf.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor //User()
@AllArgsConstructor // User(Integer id, ...)
@Builder

public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String username; //Spring Security icin gerekecek
	private String password; //Spring Security icin gerekecek
	private String roles;    //Spring Security icin gerekecek
	private boolean active;
	private LocalDateTime insertDate; // = LocalDateTime.now(); burada halletmek istesek bunu bu ekilde kullanacaktık.
	
	
	

}
