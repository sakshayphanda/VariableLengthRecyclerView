package com.sakshay.staggeredrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        List<ItemObject> list= getListItemData();
        RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<ItemObject> getListItemData()
    {
        List<ItemObject> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObject("1984", "George Orwell"));
        listViewItems.add(new ItemObject("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new ItemObject("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new ItemObject("The Book Thief", "Markus Zusak"));
        listViewItems.add(new ItemObject("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        listViewItems.add(new ItemObject("1984", "George Orwell"));
        listViewItems.add(new ItemObject("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new ItemObject("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new ItemObject("The Book Thief", "Markus Zusak"));
        listViewItems.add(new ItemObject("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        return listViewItems;
    }
}
