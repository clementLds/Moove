package com.example.moove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);//get id of button 1
        ImageView imgView = (ImageView)findViewById(R.id.imageView2);
        imgView.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imgView = (ImageView)findViewById(R.id.imageView2);
                imgView.setVisibility(View.VISIBLE);
            }
        });
    }
}
