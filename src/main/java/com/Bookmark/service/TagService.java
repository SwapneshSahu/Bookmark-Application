package com.Bookmark.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.Bookmark.DTO.TagDto;



public interface TagService {

	
	TagDto createTag(TagDto tagDto) throws SQLIntegrityConstraintViolationException;
	List<TagDto> getAllTag();
	
	void deleteTag(int id);
	
	TagDto addBookmark(int tagId ,int bookmarkId );
	
	TagDto removeBookmark(int tagId );
	
	List<TagDto> findByBookmarkId(int bookmarkID);
}
