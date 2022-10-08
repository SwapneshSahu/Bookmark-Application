package com.Bookmark.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookmark.DTO.TagDto;
import com.Bookmark.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	private TagService  tagservice;

	@PostMapping("/create")
	public ResponseEntity<TagDto> createTag( @Valid @RequestBody TagDto tagDto ) throws SQLIntegrityConstraintViolationException {
		
		return new ResponseEntity<TagDto>(this.tagservice.createTag(tagDto), HttpStatus.CREATED);
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTag(@PathVariable Integer id) {
		this.tagservice.deleteTag(0);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}

	@PutMapping("/addBookMark/tagId/{tagID}/bookmarkId/{bookmarkId}")
		public ResponseEntity<TagDto> addBookmark( @PathVariable Integer tagID ,  @PathVariable Integer bookmarkId){
		
		return new ResponseEntity<TagDto>(this.tagservice.addBookmark(tagID, bookmarkId), HttpStatus.OK);
	}
	
	@PutMapping("/reomveBookMark/tagId/{tagID}")
	public ResponseEntity<TagDto> removeBookmark( @PathVariable Integer tagID ){
	
	return new ResponseEntity<TagDto>(this.tagservice.removeBookmark(tagID), HttpStatus.OK);
   }
}
