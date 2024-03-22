package com.bookapp.util;

public class Queries {
    public static final String INSERTQUERY = "insert into book(title,author,category,book_id,price)";
    public static final String UPDATEQUERY = "update book set price=? where book_id=?";
    public static final String DELETEQUERY = "delete from book where book_id=?";
    public static final String FINDALLQUERY = "select * from book";
    public static final String FINDBYID = "select * from book where book_id=?";
    public static final String FINDBYAUTHOR = "select * from book where author=?";
    public static final String FINDBYLESSPRICE = "select * from book where price<=?";
    public static final String FINDBYAUTHORANDCATEGORY = "select * from book where author=? and category=?";
}
