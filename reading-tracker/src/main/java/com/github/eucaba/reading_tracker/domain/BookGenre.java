// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="book-genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    //// Junction tables
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    /*
    Checks whether a book genre is an empty placeholder
    (used to initialize DTO) or not.
    */
    public boolean isPlaceholder()
    {
        boolean isPlaceholder;

        if (this.name == null)
        {
            isPlaceholder = true;
        }
        else
        {
            if (this.name.isBlank())
            {
                isPlaceholder = true;
            }
            else
            {
                isPlaceholder = false;
            }
        }

        return isPlaceholder;
    }
}
