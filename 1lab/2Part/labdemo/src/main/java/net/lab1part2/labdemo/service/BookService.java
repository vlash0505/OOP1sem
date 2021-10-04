package net.lab1part2.labdemo.service;

import net.lab1part2.labdemo.model.Book;
import net.lab1part2.labdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that is used to operate on the database
 * through JpaRepository.
 */

@Service
public class BookService {
    //repository instance
    private final BookRepository bookRepository;

    /**
     * constructor to initialize BookService instance
     *
     * @param bookRepository - repository of the records we
     *                         will work with.
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Method that returns an instance of the book by the
     * given id.
     *
     * @param id id of the book to get.
     *
     * @return an instance of the book by the given id.
     */

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    /**
     * Method that returns all the records in the database.
     *
     * @return all the records in the database.
     */

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Method that saves an instance of the book.
     *
     * @param book - instance of the book to be saved
     *               in the database.
     *
     * @return - book saved to the table.
     */

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Method that deletes a record in the table by the
     * given id.
     *
     * @param id - id of the record to be removed.
     */

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}