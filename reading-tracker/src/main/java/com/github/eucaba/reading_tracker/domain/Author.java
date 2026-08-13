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
//@Table(name="")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastName;

    // Junction tables
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    // TODO: pendiente detalles de cada columna
    //p.e. @Column(nullable = false), @Column(unique = true, nullable = false)

}
