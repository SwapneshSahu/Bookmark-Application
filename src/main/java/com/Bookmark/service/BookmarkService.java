package com.Bookmark.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.Bookmark.DTO.BookmarkDto;




public interface BookmarkService {

	
	BookmarkDto createBookmark(BookmarkDto bookmark) throws SQLIntegrityConstraintViolationException;
	List<BookmarkDto> getAllBookmark();
	
	void deleteBookmark(int id);
}
