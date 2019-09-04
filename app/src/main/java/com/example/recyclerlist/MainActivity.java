package com.example.recyclerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edittextfilter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);


        final ArrayList<Items> itemsArrayList=new ArrayList<>();
        itemsArrayList.add(new Items(R.drawable.america,"America","This is America"));
        itemsArrayList.add(new Items(R.drawable.pak,"Pakistan","This is Paksitan"));
        itemsArrayList.add(new Items(R.drawable.indiasmall,"india ","This is india"));


        recyclerView.setHasFixedSize(true);

        // Linear Layout

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //GridView
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        mAdapter=new Adapter(itemsArrayList,this);

        recyclerView.setAdapter(mAdapter);


        /*recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                   // Toast.makeText(MainActivity.this, itemsArrayList.get(position), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), itemsArrayList.toString(), Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });*/
    }
}
