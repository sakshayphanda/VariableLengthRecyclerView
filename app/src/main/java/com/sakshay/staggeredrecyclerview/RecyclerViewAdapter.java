package com.sakshay.staggeredrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private final Context context;
    private final List<ItemObject> list;
    private final AdapterListener listener;
    private View view;

    public RecyclerViewAdapter(Context context, List<ItemObject> list, AdapterListener adapterListener) {
        this.context = context;
        this.list = list;
        this.listener =adapterListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.authorName.setText(list.get(i).getAuthor());
        viewHolder.bookName.setText(list.get(i).getName());
        viewHolder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

               listener.onLongClick(i,list);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView bookName;
        private final TextView authorName;
        private final CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card =itemView.findViewById(R.id.card_view);
            bookName = itemView.findViewById(R.id.BookName);
            authorName = itemView.findViewById(R.id.AuthorName);
        }
    }
}
