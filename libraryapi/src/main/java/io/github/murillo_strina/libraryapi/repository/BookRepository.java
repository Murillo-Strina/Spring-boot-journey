package io.github.murillo_strina.libraryapi.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.murillo_strina.libraryapi.model.Author;
import io.github.murillo_strina.libraryapi.model.Book;
import io.github.murillo_strina.libraryapi.model.BookGenre;

import java.math.BigDecimal;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findByAuthor(Author author);

    List<Book> findByTitle(String title);
    List<Book> findByIsbn(String isbn);
    List<Book> findByTitleAndPrice(String title, BigDecimal price);
    List<Book> findByTitleorIsbn(String title, String isbn);
    
}
