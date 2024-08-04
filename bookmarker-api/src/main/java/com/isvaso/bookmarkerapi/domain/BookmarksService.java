package com.isvaso.bookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarksService {

    private final BookmarkRepository repository;
    private final BookmarkMapper mapper;

    @Transactional(readOnly = true)
    public BookmarksResponseDTO getBookmarks(Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkResponseDTO> bookmarkPage = repository.findBookmarks(pageable);
        return new BookmarksResponseDTO(bookmarkPage);
    }

    @Transactional(readOnly = true)
    public BookmarksResponseDTO searchBookmarks(String query, Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");
//        Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query, pageable);
        Page<BookmarkResponseDTO> bookmarkPage = repository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksResponseDTO(bookmarkPage);
    }

    public BookmarkResponseDTO createBookmark(CreateBookmarkRequestDTO request) {
        Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
        Bookmark savedBookmark = repository.save(bookmark);
        return mapper.toDTO(savedBookmark);
    }
}
