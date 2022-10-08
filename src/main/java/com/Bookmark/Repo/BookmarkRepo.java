package com.Bookmark.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookmark.Modal.Bookmark;



@Repository
public interface BookmarkRepo  extends JpaRepository<Bookmark, Integer>{



}
