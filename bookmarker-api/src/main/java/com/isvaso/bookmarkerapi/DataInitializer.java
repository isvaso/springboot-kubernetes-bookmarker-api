package com.isvaso.bookmarkerapi;

import com.isvaso.bookmarkerapi.domain.Bookmark;
import com.isvaso.bookmarkerapi.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DZone", "https://dzone.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "devqlan", "https://www.devqlan.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));
    }
}
