package com.example.hitesh.assignment;

import android.content.ClipData;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int delX,delY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView=findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.maxresdefault);
        ConstraintLayout layout=findViewById(R.id.layout);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int x=(int)motionEvent.getRawX();
                final int y=(int)motionEvent.getRawY();
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    ClipData data=ClipData.newPlainText("","");
                    View.DragShadowBuilder builder=new View.DragShadowBuilder(view);
                    view.startDrag(data,builder,view,0);
                    delX=(int)motionEvent.getRawX();
                    delY=(int)motionEvent.getRawY();
                    view.setVisibility(View.INVISIBLE);

                }
                return true;
            };
        });

        layout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if (dragEvent.getAction()==DragEvent.ACTION_DROP)
                {
                    ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                    imageView.setX(dragEvent.getX()-imageView.getWidth()/2);
                    imageView.setY(dragEvent.getY()-imageView.getHeight()/2);
                    Log.v("changed x=",String.valueOf(dragEvent.getX()-imageView.getWidth()/2));
                    Log.v("changed y=",String.valueOf(dragEvent.getY()-imageView.getHeight()/2));
                    view.invalidate();
                    imageView.setVisibility(View.VISIBLE);

                }
                return true;
            }
        });
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }


}
