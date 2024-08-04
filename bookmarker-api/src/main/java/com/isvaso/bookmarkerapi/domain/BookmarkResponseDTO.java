package com.isvaso.bookmarkerapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkResponseDTO {

    private Long id;

    private String title;

    private String url;

    private Instant createdAt;
}
