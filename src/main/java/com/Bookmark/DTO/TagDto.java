package com.Bookmark.DTO;

import java.util.Date;

public class TagDto {

	
	private int id;
	private String tittle;
	private long time_created;
	private long time_updated;
	private BookmarkDto bookmark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}



	public long getTime_created() {
		return time_created;
	}

	public void setTime_created(long time_created) {
		this.time_created = time_created;
	}

	public long getTime_updated() {
		return time_updated;
	}

	public void setTime_updated(long time_updated) {
		this.time_updated = time_updated;
	}

	public BookmarkDto getBookmark() {
		return bookmark;
	}

	public void setBookmark(BookmarkDto bookmark) {
		this.bookmark = bookmark;
	}
	

	
}
