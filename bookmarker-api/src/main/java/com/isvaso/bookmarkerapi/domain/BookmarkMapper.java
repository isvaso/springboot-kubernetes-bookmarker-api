package com.isvaso.bookmarkerapi.domain;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

    public BookmarkResponseDTO toDTO(Bookmark bookmark) {
        return new BookmarkResponseDTO(
                bookmark.getId(),
                bookmark.getTitle(),
                bookmark.getUrl(),
                bookmark.getCreatedAt()
        );
    }
}
