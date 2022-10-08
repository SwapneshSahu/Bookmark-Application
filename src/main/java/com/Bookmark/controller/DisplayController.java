package com.Bookmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookmark.DTO.BookmarkDto;
import com.Bookmark.DTO.TagDto;
import com.Bookmark.service.BookmarkService;
import com.Bookmark.service.TagService;

@RestController
@RequestMapping("/display")
public class DisplayController {

	@Autowired
	private BookmarkService service;

	@Autowired
	private TagService tagservice;

	@GetMapping("/getAllBookmark")
	public ResponseEntity<List<BookmarkDto>> listOfBookmark() {

		return new ResponseEntity<List<BookmarkDto>>(this.service.getAllBookmark(), HttpStatus.OK);
	}

	@GetMapping("/getAllTag")
	public ResponseEntity<List<TagDto>> listOfTag() {

		return new ResponseEntity<List<TagDto>>(this.tagservice.getAllTag(), HttpStatus.OK);
	}

	@GetMapping("/bookmarkId/{bookmarkId}")
	public ResponseEntity<List<TagDto>> removeBookmark(@PathVariable int bookmarkId) {

		return new ResponseEntity<List<TagDto>>(this.tagservice.findByBookmarkId(bookmarkId), HttpStatus.OK);
	}
}
