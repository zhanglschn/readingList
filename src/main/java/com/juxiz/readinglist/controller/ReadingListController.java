package com.juxiz.readinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juxiz.readinglist.entity.Book;
import com.juxiz.readinglist.repository.ReadingListRepository;

@Controller
@RequestMapping("/")
//@ConfigurationProperties(prefix="amazon")
public class ReadingListController {
//	private String associateId;
	
	private ReadingListRepository readingListRepository;
	
	@Autowired
	public ReadingListController (ReadingListRepository readingListRepository){
		this.readingListRepository = readingListRepository;
	}
	
//	public void setAssociateId(String associateId) {
//		this.associateId = associateId;
//	}
	
	@RequestMapping(value="/{reader}",method=RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader,Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		if (readingList != null && !readingList.isEmpty() && readingList.size() > 0) {
			model.addAttribute("books",readingList);
//			model.addAttribute("amazonID",associateId);
		} 
		return "readingList";
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader,Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/{reader}";
	}
}