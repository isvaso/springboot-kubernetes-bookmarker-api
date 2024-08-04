package com.isvaso.bookmarkerapi.api;

import com.isvaso.bookmarkerapi.domain.BookmarkResponseDTO;
import com.isvaso.bookmarkerapi.domain.BookmarksResponseDTO;
import com.isvaso.bookmarkerapi.domain.BookmarksService;
import com.isvaso.bookmarkerapi.domain.CreateBookmarkRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bookmarks")
@RequiredArgsConstructor
public class BookmarksController {

    private final BookmarksService bookmarksService;

    @GetMapping
    public BookmarksResponseDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                             @RequestParam(name = "query", defaultValue = "") String query) {
        if (query == null || query.trim().isEmpty()) {
            return bookmarksService.getBookmarks(page);
        }
        return bookmarksService.searchBookmarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkResponseDTO createBookmark(@RequestBody @Valid CreateBookmarkRequestDTO request) {
        return bookmarksService.createBookmark(request);
    }
}
