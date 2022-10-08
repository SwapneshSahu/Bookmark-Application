package com.Bookmark.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookmark.DTO.BookmarkDto;
import com.Bookmark.service.BookmarkService;

@RestController
@RequestMapping("/bookmark")
public class BookMarkController {

	@Autowired
	private BookmarkService service;

	@PostMapping("/create")
	public ResponseEntity<BookmarkDto> createBookmark(@Valid @RequestBody BookmarkDto dto)
			throws SQLIntegrityConstraintViolationException {

		return new ResponseEntity<BookmarkDto>(this.service.createBookmark(dto), HttpStatus.CREATED);
	}

	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookmark(@PathVariable Integer id) {
		this.service.deleteBookmark(id);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
}
