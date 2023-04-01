package com.gizo.bookshalf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizo.bookshalf.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
