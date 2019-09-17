package com.example.myapplication.airplanedistance;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder = null;

    public MySurface(Context context) {
        super(context);
        surfaceHolder = getHolder();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    //public void () { //this method will be invoked to draw a
}
