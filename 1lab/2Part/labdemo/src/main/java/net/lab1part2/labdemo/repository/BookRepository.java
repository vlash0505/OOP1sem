package net.lab1part2.labdemo.repository;

import net.lab1part2.labdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that extends JpaRepository and therefore allows
 * us to use its functionality.
 */

public interface BookRepository extends JpaRepository<Book, Long> {

}
