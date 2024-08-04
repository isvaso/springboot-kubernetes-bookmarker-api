package com.isvaso.bookmarkerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookmarksResponseDTO {

    private List<BookmarkResponseDTO> data;

    private long totalElements;

    private int totalPages;

    private int currentPage;

    @JsonProperty("isFirst")
    private boolean isFirst;

    @JsonProperty("isLast")
    private boolean isLast;

    private boolean hasNext;

    private boolean hasPrevious;

    public BookmarksResponseDTO(Page<BookmarkResponseDTO> bookmarkDTOPage) {
        this.setData(bookmarkDTOPage.getContent());
        this.setTotalElements(bookmarkDTOPage.getTotalElements());
        this.setTotalPages(bookmarkDTOPage.getTotalPages());
        this.setCurrentPage(bookmarkDTOPage.getNumber() + 1);
        this.setFirst(bookmarkDTOPage.isFirst());
        this.setLast(bookmarkDTOPage.isLast());
        this.setHasNext(bookmarkDTOPage.hasNext());
        this.setHasPrevious(bookmarkDTOPage.hasPrevious());
    }
}
