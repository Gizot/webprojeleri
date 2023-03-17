package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")

public class Post implements Serializable {

	// Spring de bir veritipi yazarken bu veritipi primitive ise
	// bu veritipinin wrapper ını yazarız
	// Çünkü generic type lar (<> = diamond operatörü bu diamond içinde primitive
	// type lara izin yoktu)
	// primitive veritiplerini parametre olarak kabul etmezler.
	// Burada yazdığımız elemanları daha sonra generic type olarak kullanmak
	// istediğimizde sorun olmasın
	// diye biz direk wrapper olarak yazıyoruz.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String body;
	private Integer userId;
	// hemen getter ve setter ları oluşturalım sonra sıkıntı çıkartmasın.

	// default constructer ını oluşturdum.

	public Post() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
//BÖYLELİKLE BİZ JPA İŞLEMLERİNİ HALLETTİK burdan veritabanı işlemleri için repository e gideceğiz.
