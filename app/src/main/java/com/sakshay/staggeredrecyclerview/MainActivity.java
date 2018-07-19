package com.sakshay.staggeredrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListener{

    private RecyclerView recyclerView;
    private AdapterListener adapterListener;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterListener =this;
        initUI();
        getSupportActionBar().setTitle("Notes");
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        List<ItemObject> list = getListItemData();
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, list,adapterListener);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<ItemObject> getListItemData() {
        List<ItemObject> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObject("1984", "George Orwell"));
        listViewItems.add(new ItemObject("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new ItemObject("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new ItemObject("The Book Thief", "Markus Zusak"));
        listViewItems.add(new ItemObject("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy The Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the Galaxy ", "Douglas Adams"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        listViewItems.add(new ItemObject("1984", "George Orwell"));
        listViewItems.add(new ItemObject("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new ItemObject("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new ItemObject("The Book Thief", "Markus Zusak"));
        listViewItems.add(new ItemObject("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        listViewItems.add(new ItemObject("The Hitchhiker's Guide to the Galaxy The Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the GalaxyThe Hitchhiker's Guide to the Galaxy ", "Douglas Adams"));
        listViewItems.add(new ItemObject("The Theory Of Everything", "Dr Stephen Hawking"));
        return listViewItems;
    }

    @Override
    public void onLongClick(int position, List<ItemObject> list) {
        list.remove(position);
        recyclerView.removeViewAt(position);
        recyclerViewAdapter.notifyItemRemoved(position);
        recyclerViewAdapter.notifyItemRangeChanged(position,list.size());
        Toast.makeText(this, "Remove successfull", Toast.LENGTH_SHORT).show();
    }
}
