package com.example.myapplication.airplanedistance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.EditText;
import android.widget.TextView;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;
    private Bitmap nytola;
    private Bitmap nytofl;
    private Bitmap resizedBitmap;
    private Bitmap resizedBitmap1;


    public MySurface(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        paint.setColor(Color.RED);
        nytola = BitmapFactory.decodeResource(getResources(), R.drawable.montana);
        nytofl = BitmapFactory.decodeResource(getResources(), R.drawable.newyork);
        resizedBitmap = Bitmap.createScaledBitmap(nytola, 762, 459, false);
        resizedBitmap1 = Bitmap.createScaledBitmap(nytofl, 762, 459, false);
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
        paint = null;
    }

    public void  drawLine() {
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(4);
        canvas.drawBitmap(resizedBitmap, 0, 0, null);
        canvas.drawLine(70, 240, circleX, circleY, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(4);
        canvas.drawBitmap(resizedBitmap1, 0, 0, null);
        canvas.drawLine(600, 420, circleX, circleY, paint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}