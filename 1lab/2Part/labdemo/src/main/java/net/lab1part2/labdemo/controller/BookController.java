package net.lab1part2.labdemo.controller;

import net.lab1part2.labdemo.model.Book;
import net.lab1part2.labdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Class that represents a controller of the
 * book table with the help of object relational
 * mapping.
 */

@Controller
public class BookController {
    //using bookService to operate on table.
    private final BookService bookService;

    /**
     * Constructor for a controller.
     *
     * @param bookService  service instance through
     *                     which we will operate on
     *                     the database.
     */

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Method that gets and displays all books on the
     * main page
     *
     * @param model  model that we will add attribute
     *               to display all the books on the
     *               page "book-list"
     *
     * @return  "book-list" - main page that displays
     *           all available in the database books.
     */

    @GetMapping("/books")
    public String findAll(Model model) {
        //list of all records in the database.
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    /**
     * Method that navigates user to the book creation
     * form.
     *
     * @param book  instance to be inserted to the
     *              database.
     *
     * @return  "book-create" - navigates user to the
     *          form where user inputs data of the new
     *          record to be added to the database.
     */

    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    /**
     * After user completes pasting information into the field
     * and submits ir, redirect user to the main page.
     *
     * @param book  instance to be inserted to the
     *              database.
     *
     * @return  "redirect:/books" - redirecting user
     *          to the main page.
     */

    @PostMapping("/book-create")
    public String createBook(Book book) {
        //saving record from the user
        bookService.saveBook(book);
        return "redirect:/books";
    }

    /**
     * Method that deletes a record from the table.
     * (with the help of the functionality of the
     * JpaRepository)
     *
     * @param id  id of the record to be deleted.
     *
     * @return  "redirect:/books" - redirecting user
     *          to the main page.
     */

    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    /**
     * Method that takes record to be updated and redirects
     * user to the form where user inputs new information.
     *
     * @param id      id of the record to be updated.
     * @param model   model that represents record in the table
     *                to which we assign attribute "book" that we
     *                will update.
     *
     * @return        "/book-update" - navigating user to the update book
     *                form.
     */

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book-update";
    }

    /**
     * Method that saves updated record and navigates user
     * back to the main page.
     *
     * @param book   updated book instance.
     *
     * @return       "redirect:/books" - redirecting user
     *               back to the main page.
     */

    @PostMapping("/book-update")
    public String updateBook(Book book) {
        //saving updated record to the database.
        bookService.saveBook(book);
        return "redirect:/books";
    }
}