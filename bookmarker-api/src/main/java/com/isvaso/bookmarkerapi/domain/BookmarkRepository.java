package com.isvaso.bookmarkerapi.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.isvaso.bookmarkerapi.domain.BookmarkResponseDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkResponseDTO> findBookmarks(Pageable pageable);

    @Query("""
    select new com.isvaso.bookmarkerapi.domain.BookmarkResponseDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b
    where lower(b.title) like lower(concat('%', :query, '%'))
    """)
    Page<BookmarkResponseDTO> searchBookmarks(String query, Pageable pageable);

    Page<BookmarkResponseDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);

//    Page<BookmarkVM> findByTitleContainsIgnoreCase(String query, Pageable pageable);
}
