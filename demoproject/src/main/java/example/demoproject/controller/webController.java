package example.demoproject.controller;

import example.demoproject.model.author;
import example.demoproject.model.books;
import example.demoproject.service.authorService;
import example.demoproject.service.bookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class webController {

    private final bookService bookService;
    private final authorService authorService;

    public webController(
            bookService bookService,
            authorService authorService) {

        this.bookService = bookService;
        this.authorService = authorService;
    }

   

    @GetMapping
    public String showBooks(Model model) {

        model.addAttribute(
                "books",
                bookService.getAllBooks()
        );

        return "books";
    }


    @GetMapping("/new")
    public String showAddBookForm(Model model) {

        model.addAttribute("book", new books());

        model.addAttribute(
                "authors",
                authorService.getAllAuthors()
        );

        return "add-book";
    }


    @PostMapping("/save")
    public String saveBook(
            @Valid @ModelAttribute("book") books book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "authors",
                    authorService.getAllAuthors()
            );

            return "add-book";
        }

        author a = authorService.getAuthorById(authorId);

        book.setAuthorName(a);

        bookService.saveBook(book);

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        books book = bookService.getbookById(id);

        model.addAttribute("book", book);

        model.addAttribute(
                "authors",
                authorService.getAllAuthors()
        );

        return "edit-book";
    }


    @PostMapping("/update/{id}")
    public String updateBook(
            @PathVariable Long id,
            @Valid @ModelAttribute("book") books book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "authors",
                    authorService.getAllAuthors()
            );

            return "edit-book";
        }

        author a = authorService.getAuthorById(authorId);

        book.setAuthorName(a);

        bookService.updateBook(id, book);

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return "redirect:/books";
    }
}