package com.example.recyclerlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView txt1,txt2;
    String name,desc;
    int image;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1=findViewById(R.id.textview1);
        txt2=findViewById(R.id.textview2);
        imageView=findViewById(R.id.imageV);

        Intent i=getIntent();
        name=i.getStringExtra("name1");
        desc=i.getStringExtra("desc");
        image=i.getIntExtra("img",0);
        Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();

        txt1.setText(name);
        txt2.setText(desc);
        imageView.setImageResource(image);


    }
}
