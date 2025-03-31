package io.github.murillo_strina.libraryapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.murillo_strina.libraryapi.model.Author;
import io.github.murillo_strina.libraryapi.model.Book;
import io.github.murillo_strina.libraryapi.model.BookGenre;
import jakarta.transaction.Transactional;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void saveBook()
    {
        Book book = new Book();
        book.setIsbn("99999-99999");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGenre(BookGenre.FANTASY);
        book.setTitle("One Piece");
        book.setPublicationDate(LocalDate.of(1997,7,22));

        Author author = authorRepository.findById(UUID.fromString("3b767f86-1caa-48a0-9e97-4df0c38914a5")).orElse(null);
        
        book.setAuthor(author);

        repository.save(book);
    }

    @Test
    void updateBookAuthor()
    {
        var updateBookAuthor = repository.findById(UUID.fromString("6bef2856-042c-4b35-a438-1caeaa521c59")).orElse(null);
        Author author = authorRepository.findById(UUID.fromString("3b767f86-1caa-48a0-9e97-4df0c38914a5")).orElse(null);
        updateBookAuthor.setAuthor(author);
        repository.save(updateBookAuthor);
    }

    @Test
    void deleteBookById()
    {
        UUID deleteBookById = UUID.fromString("6bef2856-042c-4b35-a438-1caeaa521c59");
        repository.deleteById(deleteBookById);
    }

    @Test
    @Transactional
    void showBooks() {
        var id = UUID.fromString("3b767f86-1caa-48a0-9e97-4df0c38914a5");
        var author = authorRepository.findById(id).get();

        List<Book> bookList = repository.findByAuthor(author);
        author.setBooks(bookList);
        author.getBooks().forEach(System.out::println);
    }

    @Test
    void searchByTitle()
    {
        List<Book> list = repository.findByTitle("One Piece");
        list.forEach(System.out::println);
    }

    @Test
    void searchByISBN()
    {
        List<Book> list = repository.findByIsbn("99999-99999");
        list.forEach(System.out::println);
    }

    @Test
    void searchByTitleAndPrice()
    {
        var price = BigDecimal.valueOf(100);
        String title = "One Piece";
        List<Book> list = repository.findByTitleAndPrice(title, price);
        list.forEach(System.out::println);
    }


}
