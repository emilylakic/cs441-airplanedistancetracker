package com.example.myapplication.airplanedistance;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button laButton = null;
    private Button flButton = null;
    private boolean drawLine = true;
    private LinearLayout canvasLayout = null;
    MySurface customSurfaceView = null;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;

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
        mImageView=(ImageView)findViewById(R.id.imageView4);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            mImageView.setScaleX(mScaleFactor);
            mImageView.setScaleY(mScaleFactor);
            return true;
        }
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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        ((TextView) findViewById(R.id.textview1)).setText("");
        mScaleGestureDetector.onTouchEvent(motionEvent);
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();

            customSurfaceView.setCircleX(x);

            customSurfaceView.setCircleY(y);

            //Distance from CA to MT
            if(((x>=120) && (x<=250)) && ((y>=90) || (y<=95))) {
                ((TextView) findViewById(R.id.textview1)).setText("2h 18m");
            }
            //Distance from FL to NY
            if(((x>=620) && (x<=650)) && ((y>=90) || (y<=95))) {
                ((TextView) findViewById(R.id.textview1)).setText("2h 42m");
            }

            if (drawLine) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customSurfaceView.setPaint(paint);
                customSurfaceView.drawLine();
            } else {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customSurfaceView.setPaint(paint);
                customSurfaceView.drawRect();
            }
            return true;
        }else
        {
            return false;
        }
    }
}