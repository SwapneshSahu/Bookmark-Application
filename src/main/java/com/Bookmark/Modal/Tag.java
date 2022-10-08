package com.Bookmark.Modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table( uniqueConstraints = {
		@UniqueConstraint(columnNames = "tittle" )
})
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String tittle;
	private long time_created;
	private long time_updated;
	
	@ManyToOne
	private Bookmark bookmark;

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

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	

	
}
