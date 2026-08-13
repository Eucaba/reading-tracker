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
//@Table(name="")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String isbn;
    private String editorial;
    private LocalDate publicationDate;
    @Enumerated(EnumType.STRING)
    private BookFormat format;
    private int pages;

    // Junction tables
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

    // Direct relationships:
    @OneToMany(mappedBy = "book")
    //FetchType.LAZY by default.
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Reading> readings = new HashSet<>();

    // TODO: pendiente detalles de cada columna, @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    //p.e. @Column(nullable = false), @Column(unique = true, nullable = false)

}
