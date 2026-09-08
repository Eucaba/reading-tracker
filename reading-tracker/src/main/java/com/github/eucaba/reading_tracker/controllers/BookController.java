// Copyright (C) 2026 Eugenia Cames. Personal/portfolio project. All rights reserved.
package com.github.eucaba.reading_tracker.controllers;

import com.github.eucaba.reading_tracker.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    //private final BookService bookService;
    //public BookController(BookService bookService) {
    //this.bookService = bookService;
    //}

    //CRUD
    // GET forms and views
    @GetMapping("/new")
    public String showCreateForm(Model model)
    {
        BookDto bookDto = BookDto.test();
        model.addAttribute("bookDto", bookDto);
        return "book-create";
    }

    // POST resources (i.e. book)
    @PostMapping("/new")
    public String createBook(@ModelAttribute BookDto bookDto) // @ModelAttribute for Data binding
    {

        return "index";
    }

    // GET resources (book, books...)
    // PUT/PATCH resources
    // DELETE resources
    // private methods





    //CRUD
    // GET forms and views
    // POST resources (i.e. book)
    // GET resources (book, books...)
    // PUT/PATCH resources
    // DELETE resources
    // private methods

}
