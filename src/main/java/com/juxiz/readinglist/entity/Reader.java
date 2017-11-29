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
	
	//��ȡȨ��-����READERȨ��
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}
	
	//�˻��Ƿ񲻹���
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//�˻��Ƿ񲻼���
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//ƾ֤�Ƿ񲻹���
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//�Ƿ�����
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}