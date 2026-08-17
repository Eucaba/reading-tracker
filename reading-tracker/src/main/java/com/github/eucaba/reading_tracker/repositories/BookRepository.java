// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.repositories;

import com.github.eucaba.reading_tracker.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    // TODO: complete this repository and create all the rest

    // Using Optional is a usual method to avoid managing Null Pointer Exceptions.
    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);


}
