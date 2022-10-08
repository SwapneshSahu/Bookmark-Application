package com.Bookmark.Modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table( uniqueConstraints = {
		@UniqueConstraint(columnNames = "link" )
})
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String link;
	private String tittle;
	private long time_created;
	private long time_updated;
	private String publisher;
	
	@OneToMany(mappedBy = "bookmark" ,cascade = CascadeType.ALL)
	private List<Tag> tag = new ArrayList<>();
	
	
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
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	
	

}
