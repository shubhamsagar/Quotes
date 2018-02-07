package com.shubham.quotes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SHUBHAM on 12/27/2017.
 */



public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<ListItem> listItems;
    private Context context ;
    public MyAdapter(List<ListItem> listItems, Context context)
    {
        this.listItems = listItems;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlayout,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {

        final ListItem listItem =  listItems.get(position);



        holder.quote.setText(listItem.getQuote());
        holder.author.setText(listItem.getAuthor());
        holder.category.setText(listItem.getCategory());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder
    {

        public TextView quote;
        public TextView author;
        public TextView category;
        public ViewHolder(View itemView)
        {
            super(itemView);
            quote = (TextView)itemView.findViewById(R.id.item_quote);
            author = (TextView)itemView.findViewById(R.id.item_author);
            category = (TextView)itemView.findViewById(R.id.item_category);

        }
    }
}