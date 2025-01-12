package com.example.BookManage.service;

import com.example.BookManage.domain.Book;
import com.example.BookManage.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
            return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setPrice((bookDetails.getPrice()));
                    book.setStock(bookDetails.getStock());
                    return bookRepository.save(book);
                })
                ;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
