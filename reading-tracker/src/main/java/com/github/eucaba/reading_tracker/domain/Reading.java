// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="reading")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingStatus status;

    @Column(nullable = false)
    private LocalDate creationDate;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private int totalPages;

    @Column(nullable = false)
    private int currentPage;

    private BigDecimal percentageProgress;

    //// Direct relationships:
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //// To improve performance gives a proxy and only fetches the object when explicitly asked.
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser appUser;
}
