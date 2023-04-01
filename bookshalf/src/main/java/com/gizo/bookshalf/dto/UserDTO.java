package com.gizo.bookshalf.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gizo.bookshalf.entity.User;

public class UserDTO implements UserDetails {
	
	private User user; //User ı import ederken kendi projene ait dogru package daki user ı importladıgından emin olmalısın
	
	//biz metod cagırmak icin autowired kullanırız
	//bu yuzden burada veri cagırmak icin constructor kullanımı uygun
	//ve bu constructor icinde user nesnesinin gelmesi sart
	//ve sana user nesnesini saglıyor(enjekte ediyor)
	//boylelikle bu constructor aracılıgıyla dependency ınjection yapmıs oldum
	//dependenciy injection via constructor
	
	public UserDTO(User user){
		
		this.user = user; //bu user a dısarıdan gelecek user ı atamıs oldum
		
		
		
	}
//burdaki soru isareti herhangi bir sınıf anlamına geliyor
	//GrantedAuthority i implemente eden herhangi bir sınıfı donebilir anlamına geliyor
	//collection da generateList in atası yani buraya List te yazılabilirdi
	//Authorities ler ise kisinin izinlerini ifade eder
	//roles: ROLE_USER, ROLE_ADMIN, ROLE_DATA_EXPERT 
	//seklinde roles.split diyerek rolleri virgulle ayırmasını istedigimi belirtecegim
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = user.getRoles();
		String[] autohorities = roles.split(",");
		
		List<SimpleGrantedAuthority> returnAuthorities = new ArrayList<>();
		//elimde array oldugu icin for dongusuyle donecegım
		
		for (int i = 0; i < autohorities.length; i++) {
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(autohorities[i]);
			
			returnAuthorities.add(auth);
		}
		
		//return returnAuthorities; 
		
		//asagıda da ıkıncı yontem var
		//userların yetkılı rollerini aldım,split ettim, sonra her bir rolunden
		//bir tane simplegrantedauthority olusturdum(new kelimesi o anlama geliyor)
		//newleyerek yeni nesneleri olusturdum ve sonra o listeyi dondum
		return Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword(); //user class ta security icin tanımladıgımız password lazım oldu
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();// user class ta security icin tanımladıgımız username lazım oldu
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; //hesabın bir son kullanma tarihi olmasın true
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; //kilitli olmasın true
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; //son kullanma tarihi olmasına true dedik
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;  //burayı true yaptık
	}

}
