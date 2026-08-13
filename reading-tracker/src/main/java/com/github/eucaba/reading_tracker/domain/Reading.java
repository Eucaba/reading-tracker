// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
