package com.test.bookpub;

import com.test.bookpub.Repository.BookRepository;
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

    public void run(String... args) throws Exception {
        //logger.info("Number of books: " + bookRepository.count());
    }

    //Planlamış olarak yapmamızı sağlıyor bu annotation bunu kullanabilmek için @EnabledScheduled ı eklememiz gerekiyor bunu BookPubApplication.java da ekledik
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        logger.info("Number of books: " + bookRepository.count());
    }
}
