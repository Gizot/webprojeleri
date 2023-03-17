package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Post;
import com.example.demo.repository.PostRepository;

//Business Logic Layer

public class PostService {

	// ınversion of control ile yazmam lazım

	@Autowired // IoC yi ilk burada kullandık.
	private PostRepository repo;

	public Post ekle(Post post) {

		repo.save(post);

		return post;

	}

}
