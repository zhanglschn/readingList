package com.juxiz.readinglist.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Reader implements UserDetails{
	private static final long serialVersionUID = 854681L;
	@Id
	private String username;
	private String fullname;
	private String password;
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// UserDetails methods
	
	//获取权限-授予READER权限
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}
	
	//账户是否不过期
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//账户是否不加锁
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//凭证是否不过期
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//是否启用
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}