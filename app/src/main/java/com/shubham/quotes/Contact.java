package com.shubham.quotes;

/**
 * Created by SHUBHAM on 12/30/2017.
 */

public class Contact {

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_quote() {
        return _quote;
    }

    public void set_quote(String _quote) {
        this._quote = _quote;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public Contact(int _id, String _quote, String _author, String _category) {
        this._id = _id;
        this._quote = _quote;
        this._author = _author;
        this._category = _category;
    }
    public Contact()
    {

    }
    //private variables
    int _id;
    String _quote;
    String _author;
    String _category;
}
