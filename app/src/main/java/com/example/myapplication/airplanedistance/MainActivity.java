package com.example.myapplication.airplanedistance;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button laButton = null;
    private Button flButton = null;
    private boolean drawLine = true;
    private LinearLayout canvasLayout = null;
    MySurface customSurfaceView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        customSurfaceView = new MySurface(getApplicationContext());
        customSurfaceView.setOnTouchListener(this);
        canvasLayout.addView(customSurfaceView);
        laButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine = true;

            }
        });
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine = false;

            }
        });
    }

    private void initControls() {
        if(laButton == null) {
            laButton = (Button)findViewById(R.id.laButton);
        }
        if(flButton == null) {
            flButton = (Button)findViewById(R.id.flButton);
        }
        if(canvasLayout == null)
        {
            canvasLayout = (LinearLayout)findViewById(R.id.customViewLayout);
        }
    }

    /* If user finger touch the surfaceview object. */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();


            customSurfaceView.setCircleX(x);

            customSurfaceView.setCircleY(y);

            if (drawLine) {
                // Create and set a red paint to custom surfaceview.
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customSurfaceView.setPaint(paint);

                customSurfaceView.drawLine();
            } else {
                // Create and set a green paint to custom surfaceview.
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customSurfaceView.setPaint(paint);

                customSurfaceView.drawRect();
            }

            // Tell android os the onTouch event has been processed.
            return true;
        }else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }
}