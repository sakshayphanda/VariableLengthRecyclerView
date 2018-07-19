package com.sakshay.staggeredrecyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.sakshay.staggeredrecyclerview.RecyclerViewAdapter.list;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private AdapterListener adapterListener;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ItemTouchHelper itemTouchHelper;
   // private List<ItemObject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        getSupportActionBar().setTitle("Notes");
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        List<ItemObject> listData = getListItemData();
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, listData);
        recyclerView.setAdapter(recyclerViewAdapter);
        ItemTouchHelper.SimpleCallback simpleCallback= new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                final ItemObject currentData = list.get(position);
                Snackbar snackbar = Snackbar
                        .make(recyclerView, "PHOTO REMOVED", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                list.add(position, currentData);
                                recyclerViewAdapter.notifyItemInserted(position);
                                recyclerView.scrollToPosition(position);
                                //photosToDelete.remove(mPhoto);
                            }
                        });
                snackbar.show();
                list.remove(position);
            //    recyclerView.removeViewAt(position);
                recyclerViewAdapter.notifyItemRemoved(position);
                recyclerViewAdapter.notifyItemRangeChanged(position,list.size());
                ///       Toast.makeText(MainActivity.this, "Remove successfull", Toast.LENGTH_SHORT).show();

            }
        };
        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


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
}
