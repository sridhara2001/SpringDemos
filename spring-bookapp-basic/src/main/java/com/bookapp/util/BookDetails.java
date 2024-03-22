package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookDetails {
    public List<Book> showBooks(){
        return Arrays.asList(
                new Book("Virat Kohli","Sridhar","Cricket",18,1000),
                new Book("AB Devilliers","Prashanth","Hockey",17,500),
                new Book("MS Dhoni","Adarsh","Football",7,600),
                new Book("Maxwell","Chida","Golf",32,400),
                new Book("Rajath","Sridhar","Cricket",19,400)
        );
    }
}
