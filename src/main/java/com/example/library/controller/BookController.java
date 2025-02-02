package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}