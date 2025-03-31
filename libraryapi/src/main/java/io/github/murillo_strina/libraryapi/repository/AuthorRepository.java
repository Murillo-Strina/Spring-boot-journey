package io.github.murillo_strina.libraryapi.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.murillo_strina.libraryapi.model.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    

}
