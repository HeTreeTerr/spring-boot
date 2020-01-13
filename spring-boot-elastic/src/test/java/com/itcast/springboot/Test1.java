package com.itcast.springboot;

import com.itcast.springboot.bean.Book;
import com.itcast.springboot.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Autowired
    BookRepository bookRepository;
    @Test
    public void test(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("hss`s book");
        book.setAuthor("hss");
        bookRepository.index(book);
    }
    @Test
    public void test1(){
        List<Book> byBookNameLike = bookRepository.findByBookNameLike("h");
        System.out.println(byBookNameLike);
        bookRepository.delete(1);

        Book one = bookRepository.findOne(1);
        System.out.println(one);
    }
}
