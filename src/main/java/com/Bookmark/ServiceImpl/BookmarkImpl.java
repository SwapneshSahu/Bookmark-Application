package com.Bookmark.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookmark.DTO.BookmarkDto;
import com.Bookmark.Excep.ResourceNotFoundException;
import com.Bookmark.Modal.Bookmark;
import com.Bookmark.Repo.BookmarkRepo;
import com.Bookmark.Repo.TagRepo;
import com.Bookmark.service.BookmarkService;




@Service
public class BookmarkImpl implements BookmarkService {
	
	
	@Autowired
	private BookmarkRepo bookMarkRepo;
	
	@Autowired
	private TagRepo tagRepo;

	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookmarkDto createBookmark(BookmarkDto bookmarkDto) {
		
		Bookmark bookmark = this.dtoToBookmark(bookmarkDto);
			bookmark.setTime_created(System.currentTimeMillis());
			bookmark.setTime_updated(System.currentTimeMillis());
		
			this.bookMarkRepo.save(bookmark);
		
		return this.bookmarkToDto(bookmark);
		
		
	}

	@Override
	public List<BookmarkDto> getAllBookmark() {
		
		List<Bookmark> bookmarkList  = this.bookMarkRepo.findAll();
		
		List<BookmarkDto> bookmarkDto = bookmarkList.stream().map(bookmark -> this.bookmarkToDto(bookmark))
				.collect(Collectors.toList());
		return bookmarkDto;
	}

	@Override
	public void deleteBookmark(int id) {
		Bookmark bookmark = this.bookMarkRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bookmark", "id", id));
		
		this.bookMarkRepo.delete(bookmark);
		
	}
	
	private Bookmark dtoToBookmark(BookmarkDto bookmarkDto) {

		Bookmark bookmark = this.modelMapper.map(bookmarkDto, Bookmark.class);

		return bookmark;

	}

	private BookmarkDto bookmarkToDto(Bookmark bookmark) {

		BookmarkDto bookmarkDto = this.modelMapper.map(bookmark, BookmarkDto.class);


		return bookmarkDto;

	}

}
