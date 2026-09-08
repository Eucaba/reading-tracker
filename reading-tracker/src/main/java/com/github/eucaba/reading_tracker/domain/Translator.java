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
@Table(name="translator")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Translator {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String lastName;

    //// Junction tables
    @ManyToMany(mappedBy = "translators")
    private Set<Book> books = new HashSet<>();

    /* Checks whether a translator is an empty placeholder
    (used to initialize DTO) or not. */
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
