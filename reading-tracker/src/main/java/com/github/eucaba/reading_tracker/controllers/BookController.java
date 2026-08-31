// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.controllers;

import com.github.eucaba.reading_tracker.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping("/new")
    public String getBookCreateForm(Model model) {

        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);

        return "book-create";
    }

    /*
    // GET /books -> Lista los libros
    @GetMapping
    public String listBooks(Model model) {
        return "book-list";
    }

    @PostMapping
public String saveBook(@ModelAttribute Book book) {
    // 1. Guardar el libro en la base de datos
    // 2. Redirigir para evitar el reenvío duplicado del formulario
    return "redirect:/books";
}

    // POST /books -> Procesa el formulario y guarda el libro
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        // Guardar en la base de datos...
        return "redirect:/books";
    }
     */
}
