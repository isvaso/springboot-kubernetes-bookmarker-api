package com.isvaso.bookmarkerapi.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreateBookmarkRequestDTO {

    @NotEmpty(message = "Title should not be empty")
    private String title;

    @NotEmpty(message = "URL should not be empty")
    private String url;

}
