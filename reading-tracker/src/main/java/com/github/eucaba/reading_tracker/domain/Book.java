// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String isbn;

    private String publisher;

    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    private BookFormat format;

    @Column(nullable = false)
    private int pages;

    //// Junction tables
    @ManyToMany
    //FetchType.LAZY by default.
    @JoinTable(name = "jt_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "jt_book_translator",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "translator_id"))
    private Set<Translator> translators = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "jt_book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<BookGenre> genres = new HashSet<>();

    //// Direct relationships:
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    //OneToMany: FetchType.LAZY by default.
    //CascadeType.ALL propagates ALL persistance operations from parent to child.
    //OrphanRemoval detects all orphans and avoids invalid registers in jt tables.
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reading> readings = new HashSet<>();

    /* Basic existing book constructor */
    public Book(UUID id, String title, String isbn, String publisher, LocalDate publicationDate, BookFormat format,
                int pages, Set<Author> authors, Set<Translator> translators, Set<BookGenre> genres)
    {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.format = format;
        this.pages = pages;
        this.authors = authors;
        this.translators = translators;
        this.genres = genres;
    }

    /* Basic non-yet-existing book constructor */
    public Book(String title, String isbn, String publisher, LocalDate publicationDate, BookFormat format,
                int pages, Set<Author> authors, Set<Translator> translators, Set<BookGenre> genres)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.format = format;
        this.pages = pages;
        this.authors = authors;
        this.translators = translators;
        this.genres = genres;
    }
}
