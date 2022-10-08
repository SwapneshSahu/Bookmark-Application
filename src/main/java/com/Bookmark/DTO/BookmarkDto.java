package com.Bookmark.DTO;

import java.util.Date;


public class BookmarkDto {

	
	private int id;
	private String link;
	private String tittle;
	private long time_created;
	private long time_updated;
	private String publisher;
	
	//private List<TagDto> tagDto= new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
//	public List<TagDto> getTagDto() {
//		return tagDto;
//	}
//	public void setTagDto(List<TagDto> tagDto) {
//		this.tagDto = tagDto;
//	}

	
	
	

}
