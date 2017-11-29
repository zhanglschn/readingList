package com.juxiz.readinglist.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.juxiz.readinglist.repository.ReaderRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private ReaderRepository readerRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		//要求登陆者有READER角色
		.antMatchers("/").access("hasRole('READER')")
		.antMatchers("/**").permitAll()
		
		.and()
		
		// 设置登录表单的路径和错误信息
		.formLogin().loginPage("/login")
		.failureUrl("/login?error=true");
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return readerRepository.findOne(username);
			}
		});
	}
}