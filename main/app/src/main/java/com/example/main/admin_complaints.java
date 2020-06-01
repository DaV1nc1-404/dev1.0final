package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class admin_complaints extends AppCompatActivity {
    ProgressBar progressbar;
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    Adapter adapter;
    Boolean scroll =false;
    int currentitems,scrolleditems,totalitems;
    ArrayList list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_complaints);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        manager = new LinearLayoutManager(this);
        String[] s = {"complaint 1", "complaint 2", "complaint 3", "complaint 4", "complaint 5", "complaint 6", "complaint 7", "complaint 8", "complaint 9", "complaint 10" ,"complaint 10" ,"complaint 10" ,"complaint 10", "complaint 10" ,"complaint 10" ,"complaint 10"};
        ArrayList list = new ArrayList(Arrays.asList(s));
        adapter = new Adapter(list, this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    scroll = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentitems = manager.getChildCount();
                totalitems = manager.getItemCount();
                scrolleditems = manager.findFirstCompletelyVisibleItemPosition();
                if (scroll && (currentitems + scrolleditems == totalitems)) {
                    scroll = false;
                    fetchData();
                }
            }
        });

    }



    private void fetchData() {
        progressbar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    list1.add(Math.floor(Math.random()*100)+ "");
                    adapter.notifyDataSetChanged();
                    progressbar.setVisibility(View.GONE);

                }
            }
        },3000);

    }




}
