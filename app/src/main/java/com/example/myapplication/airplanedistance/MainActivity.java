package com.example.myapplication.airplanedistance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {

    }

//User finger touch surfaceview object
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
