package com.example.myapplication.airplanedistance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SurfaceView view = new SurfaceView(this);
        //setContentView(view);
        //view.getHolder().addCallback((SurfaceHolder.Callback) this);
        setContentView(R.layout.activity_main);
    }


}
