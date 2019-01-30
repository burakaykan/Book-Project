package com.test.bookpub;

import com.test.bookpub.Model.Author;
import com.test.bookpub.Model.Book;
import com.test.bookpub.Model.Publisher;
import com.test.bookpub.Repository.AuthorRepository;
import com.test.bookpub.Repository.BookRepository;
import com.test.bookpub.Repository.PublisherRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;


public class StartupRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public void run(String... args) throws Exception {
        //logger.info("Number of books: " + bookRepository.count());
    }

    //Planlamış olarak yapmamızı sağlıyor bu annotation bunu kullanabilmek için @EnabledScheduled ı eklememiz gerekiyor bunu BookPubApplication.java da ekledik
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        logger.info("Number of books: " + bookRepository.count());

        Author author = new Author("Alex", "Antonov");
        author = authorRepository.save(author);
        Publisher publisher = new Publisher("Packt");
        publisher = publisherRepository.save(publisher);
        Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author, publisher);
        bookRepository.save(book);
    }

}
