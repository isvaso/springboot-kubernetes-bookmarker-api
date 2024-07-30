package com.isvaso.bookmarkerapi.api;

import com.isvaso.bookmarkerapi.domain.Bookmark;
import com.isvaso.bookmarkerapi.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///test"
})
class BookmarksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAllInBatch();
        bookmarks = List.of(
                new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()),
        new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()),
        new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()),
        new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()),
        new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()),
        new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()),
        new Bookmark(null, "DZone", "https://dzone.com", Instant.now()),
        new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()),
        new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()),
        new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()),
        new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()),
        new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()),
        new Bookmark(null, "devqlan", "https://www.devqlan.com", Instant.now()),
        new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now())
        );
        
        bookmarkRepository.saveAll(bookmarks);
    }

    @Test
    void should_GetBookmarks_when_GetWithoutParameters() throws Exception {
        mockMvc.perform(get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(14)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(2)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(false)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(false)));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 14, 2, 1, true, false, true, false",
            "2, 14, 2, 2, false, true, false, true",
    })
    void should_GetBookmarks_when_GetWithParameters(
            int pageNumber,
            int totalElements,
            int totalPages,
            int currentPage,
            boolean isFirst,
            boolean isLast,
            boolean hasNext,
            boolean hasPrevious
            ) throws Exception {
        mockMvc.perform(get("/api/bookmarks?page=" + pageNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
    }
}