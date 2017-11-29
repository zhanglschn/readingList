package com.juxiz.readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juxiz.readinglist.entity.Reader;
public interface ReaderRepository extends JpaRepository<Reader,String>{
	
}