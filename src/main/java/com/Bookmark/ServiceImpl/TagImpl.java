package com.Bookmark.ServiceImpl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookmark.DTO.TagDto;
import com.Bookmark.Excep.ResourceNotFoundException;
import com.Bookmark.Modal.Bookmark;
import com.Bookmark.Modal.Tag;
import com.Bookmark.Repo.BookmarkRepo;
import com.Bookmark.Repo.TagRepo;
import com.Bookmark.service.TagService;



@Service
public class TagImpl implements TagService {

	@Autowired
	private TagRepo tagRepo;

	@Autowired
	private BookmarkRepo bookMarkRepo;
	@Autowired
	private ModelMapper modelMapper;
 
	@Override
	public TagDto createTag(TagDto tagDto  ) throws SQLIntegrityConstraintViolationException {
		
		 Tag tag = this.dtoToTag(tagDto);
		tag.setTime_created(System.currentTimeMillis());
		tag.setTime_updated(System.currentTimeMillis());
		this.tagRepo.save(tag);
		return this.tagToDto(tag);
	}

	@Override
	public List<TagDto> getAllTag() {

		List<Tag> tagList = this.tagRepo.findAll();

		List<TagDto> bookmarkDto = tagList.stream().map(tag -> this.tagToDto(tag)).collect(Collectors.toList());
		return bookmarkDto;
	}

	@Override
	public void deleteTag(int id) {
		Tag tag = this.tagRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));

		this.tagRepo.delete(tag);

	}


	@Override
	public TagDto addBookmark(int tagId, int bookmarkId) {
		Bookmark bookmark = this.bookMarkRepo.findById(bookmarkId)
				.orElseThrow(() -> new ResourceNotFoundException("Bookmark", "id", bookmarkId));

		Tag tag = this.tagRepo.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", tagId));

		tag.setBookmark(bookmark);
		tag.setTime_updated(System.currentTimeMillis());
		this.tagRepo.save(tag);

		return this.tagToDto(tag);
	}
	
	@Override
	public TagDto removeBookmark(int tagId) {
		Tag tag = this.tagRepo.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", tagId));

		tag.setBookmark(null);
		tag.setTime_updated(System.currentTimeMillis());
		this.tagRepo.save(tag);

		return this.tagToDto(tag);
		
	}
	
	
	@Override
	public List<TagDto> findByBookmarkId(int bookmarkID ){
		
		Bookmark bookmark = this.bookMarkRepo.findById(bookmarkID)
				.orElseThrow(() -> new ResourceNotFoundException("Bookmark", "id", bookmarkID));
		
		List<TagDto> tagDtoList = this.tagRepo.findByBookmark(bookmark).stream()
				.map((tag) -> this.modelMapper.map(tag, TagDto.class)).collect(Collectors.toList());
		return tagDtoList;


	}
	
	private Tag dtoToTag(TagDto tagDto) {

		Tag tag = this.modelMapper.map(tagDto, Tag.class);

		return tag;

	}

	private TagDto tagToDto(Tag tag) {

		TagDto tagDto = this.modelMapper.map(tag, TagDto.class);

		return tagDto;

	}

	

}
