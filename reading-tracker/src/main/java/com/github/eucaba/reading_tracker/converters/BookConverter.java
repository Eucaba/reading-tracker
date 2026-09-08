// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.converters;

import com.github.eucaba.reading_tracker.domain.*;
import com.github.eucaba.reading_tracker.dto.BookDto;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.*;

@Component
// Identifies class as Bean, so we can inject it into services with @Autowired or constructor.
public class BookConverter {

    // TODO comment
    public Book convertDtoToBook(BookDto dto)
    {
        Assert.notNull(dto, "The Book DTO CAN NOT be null");

        // Get all dto attributes that are direct equivalents to book attributes:
        UUID id = dto.getId();
        String title = dto.getTitle();
        String isbn = dto.getIsbn();
        String publisher = dto.getPublisher();
        LocalDate publicationDate = dto.getPublicationDate();
        int pages = dto.getPages();
        BookFormat format = dto.getFormat();

        // For authors and translators, if any, retrieve and add them to book:
        Set<Author> authors = new HashSet<>();
        Set<Translator> translators = new HashSet<>();

        List<Author> authorsDtoList = dto.getAuthors();

        for (int i = 0; i < authorsDtoList.size(); i++)
        {
            // Check whether the author has content or is a placeholder.
            Author author = authorsDtoList.get(i);
            boolean isAuthorPlaceholder = author.isPlaceholder();

            if (!isAuthorPlaceholder)
            {
                authors.add(author);
            }
        }

        List<Translator> translatorsDtoList = dto.getTranslators();

        for (int j = 0; j < translatorsDtoList.size(); j++)
        {
            // Check whether the translator has content or is a placeholder.
            Translator translator = translatorsDtoList.get(j);
            boolean isTranslatorPlaceholder = translator.isPlaceholder();

            if (!isTranslatorPlaceholder)
            {
                translators.add(translator);
            }
        }

        // TODO this, ull
        Set<BookGenre> genres = new HashSet<>();

        Book book = new Book(
                id,
                title,
                isbn,
                publisher,
                publicationDate,
                format,
                pages,
                authors,
                translators,
                genres);

        return book;
    }

    // TODO comment
    public BookDto convertBookToDto(Book book)
    {
        Assert.notNull(book, "The Book CAN NOT be null");

        // Get all dto attributes that are direct equivalents to book dto attributes:

        UUID id = book.getId();
        String title = book.getTitle();
        String isbn = book.getIsbn();
        String publisher = book.getPublisher();
        LocalDate publicationDate = book.getPublicationDate();
        int pages = book.getPages();
        BookFormat format = book.getFormat();
        List<Author> authors = new ArrayList<>();
        List<Translator> translators = new ArrayList<>();

        // For authors and translators, if any, retrieve and add them to book dto:
        Set<Author> bookAuthors = book.getAuthors();
        boolean isAuthorsSetEmpty = bookAuthors.isEmpty();

        if (!isAuthorsSetEmpty)
        {
            Iterator<Author> iterator = bookAuthors.iterator();

            while (iterator.hasNext())
            {
                Author author = iterator.next();

                // Check whether the author has content or is a placeholder.
                boolean isAuthorPlaceholder = author.isPlaceholder();
                // Add only real authors.
                if (!isAuthorPlaceholder)
                {
                    authors.add(author);
                }
            }

        }

        Set<Translator> bookTranslators = book.getTranslators();
        boolean isTranslatorsSetEmpty = bookTranslators.isEmpty();

        if (!isTranslatorsSetEmpty)
        {
            Iterator<Translator> iterator = bookTranslators.iterator();

            while (iterator.hasNext())
            {
                Translator translator = iterator.next();

                // Check whether the translator has content or is a placeholder.
                boolean isTranslatorPlaceholder = translator.isPlaceholder();
                // Add only real authors.
                if (!isTranslatorPlaceholder)
                {
                    translators.add(translator);
                }
            }
        }

        // OJO todo GENRES

        BookDto dto = new BookDto();
        return dto;
    }


}
