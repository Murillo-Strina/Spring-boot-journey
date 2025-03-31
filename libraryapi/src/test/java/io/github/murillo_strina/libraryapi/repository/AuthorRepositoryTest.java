package io.github.murillo_strina.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.murillo_strina.libraryapi.model.Author;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository repository;

    @Test
    public void saveTest() {
        Author author = new Author();
        author.setName("Eiichiro Oda");
        author.setNationality("Japonês");
        author.setDateOfBirth(LocalDate.of(1975, 1, 1));

        var authorSaved = repository.save(author);
        System.out.println("Author saved: " + authorSaved);
    }

    @Test
    public void updateTest() {
        var id = UUID.fromString("c0455470-39d7-4006-a259-78e6a965957a");
        Optional<Author> possibleAuthor = repository.findById(id);
        if (possibleAuthor.isPresent()) {
            Author author = possibleAuthor.get();
            System.out.println("Author data: ");
            System.out.println(possibleAuthor.get());

            author.setName("Felipe");

            repository.save(author);
        } else
            System.err.println("Author not found!");
    }

    @Test
    @Transactional
    public void showAuthors() {
        List<Author> list = repository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Total authors: " + repository.count());
    }

    @Test
    public void deleteAuthorById()
    {
        var id = UUID.fromString("8f24b764-2832-4eff-903d-b41a0c579805");
        repository.deleteById(id);
    }
}
