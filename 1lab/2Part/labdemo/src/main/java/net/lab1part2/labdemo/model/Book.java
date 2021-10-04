package net.lab1part2.labdemo.model;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Class that represents entity that we store in
 * the database.
 */

@Data
@Entity
@Table(name = "books")
public class Book {
    // primary key field, uses autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //columns of the table
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "date")
    private Date date;
    @Column(name = "pages")
    private int pages;
    @Column(name = "annotation")
    private String annotation;
}