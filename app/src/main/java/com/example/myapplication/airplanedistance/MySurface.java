package com.example.myapplication.airplanedistance;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder = null;
    private float circleX = 0;
    private float circleY = 0;

    public MySurface(Context context) {
        super(context);
        surfaceHolder = getHolder();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawLine();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
//whatever you use to create the line, like paint = null;
    }

    public void  drawLine() {
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();

        }
    }
