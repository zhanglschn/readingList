package com.juxiz.readinglist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juxiz.readinglist.entity.Book;

public interface ReaderRepository extends JpaRepository<Book,Long>{
	List<Book> findByReader(String reader);
}