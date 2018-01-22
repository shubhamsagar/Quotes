package com.shubham.quotes;

/**
 * Created by SHUBHAM on 12/27/2017.
 */

public class ListItem {

    private String quote;
    private String author;
    private String category;

    public ListItem() {

    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }


    public ListItem(String quote, String author, String category) {
        this.quote = quote;
        this.author = author;
        this.category = category;
    }


}
