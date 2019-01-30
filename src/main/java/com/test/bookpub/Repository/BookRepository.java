package com.test.bookpub.Repository;

import com.test.bookpub.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public Book findByIsbn(String isbn);
}
