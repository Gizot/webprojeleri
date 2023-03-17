package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Post;

//Dikkat edersek burada interface ,interface i extendledi.

public interface PostRepository extends JpaRepository<Post, Integer> {

}
