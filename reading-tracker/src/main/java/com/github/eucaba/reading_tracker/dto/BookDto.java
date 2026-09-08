// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.dto;

import com.github.eucaba.reading_tracker.domain.Author;
import com.github.eucaba.reading_tracker.domain.BookFormat;
import com.github.eucaba.reading_tracker.domain.BookGenre;
import com.github.eucaba.reading_tracker.domain.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private UUID id;
    private String title;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private BookFormat format;
    private int pages;
    private List<Author> authors = new ArrayList<>();
    private List<Translator> translators = new ArrayList<>();
    private List<BookGenre> genres = new ArrayList<>();

    //BookCreateForm
    public static BookDto test()
    {
        BookDto book = new BookDto();

        // Populate book authors, translators and genres
        // with default placeholders.
        for (int i = 0; i < 5; i++)
        {
            Author author = new Author();
            book.authors.add(author);
        }

        for (int j = 0; j < 3; j++)
        {
            Translator translator = new Translator();
            book.translators.add(translator);
        }

        for (int k = 0; k < 3; k++)
        {
            BookGenre genre = new BookGenre();
            book.genres.add(genre);
        }

        return book;
    }
}
