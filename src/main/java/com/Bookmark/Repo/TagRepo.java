package com.Bookmark.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookmark.Modal.Bookmark;
import com.Bookmark.Modal.Tag;



@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {

	List<Tag> findByBookmark(Bookmark bookmark);

}
