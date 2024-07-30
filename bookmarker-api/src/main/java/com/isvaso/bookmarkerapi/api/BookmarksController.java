package com.isvaso.bookmarkerapi.api;

import com.isvaso.bookmarkerapi.domain.Bookmark;
import com.isvaso.bookmarkerapi.domain.BookmarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bookmarks")
@RequiredArgsConstructor
public class BookmarksController {

    private final BookmarksService bookmarksService;

    @GetMapping
    public List<Bookmark> getBookmarks(
            @RequestParam(name = "page", defaultValue = "1") Integer page
    ) {
        return bookmarksService.getBookmarks(page);
    }
}
