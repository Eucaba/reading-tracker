// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
//@Table(name="")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private int rating;
    private String title;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // TODO: pendiente detalles de cada columna
    //p.e. @Column(nullable = false), @Column(unique = true, nullable = false)
}
