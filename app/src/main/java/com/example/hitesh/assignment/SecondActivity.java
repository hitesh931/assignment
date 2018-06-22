package com.example.hitesh.assignment;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button=findViewById(R.id.button2);
        final ConstraintLayout layout=findViewById(R.id.layout1);
        final TextView textView=findViewById(R.id.textView4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Blurry.with(getApplicationContext()).radius(25).sampling(2).onto((ViewGroup) layout);
                textView.setVisibility(View.VISIBLE);
            }
        });
    }
}
