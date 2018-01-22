package com.shubham.quotes;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class favourite extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        adapter = new MyAdapter(listItems, getApplicationContext());
        TextView textView = (TextView)findViewById(R.id.noitem);
        db =  new DatabaseHandler(this);
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts)
        {
            String quote  = cn.get_quote();
            String author = cn.get_author();
            String category = cn.get_category();

                ListItem listItem =  new ListItem(quote,author,category);
                listItems.add(listItem);
                adapter.notifyDataSetChanged();

        }
        if(adapter.getItemCount()!=0)
        {
            recyclerView.setAdapter(adapter);

        }
        else
        {
            textView.setText("Your Quotes will be stored here....");
        }
    }
}
