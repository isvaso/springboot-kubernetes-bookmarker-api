package com.isvaso.bookmarkerapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
