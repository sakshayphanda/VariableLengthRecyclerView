package com.sakshay.staggeredrecyclerview;

import java.util.List;

public interface AdapterListener {
    void onLongClick(int position, List<ItemObject> list);
}
