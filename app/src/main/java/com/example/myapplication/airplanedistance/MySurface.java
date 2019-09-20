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
    private int thisX = 600;
    private int thisY = 420;


    public MySurface(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        paint.setColor(Color.RED);
        nytola = BitmapFactory.decodeResource(getResources(), R.drawable.losangeles);
        nytofl = BitmapFactory.decodeResource(getResources(), R.drawable.florida);
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
        // Set the surfaceview background color
        surfaceBackground.setColor(Color.WHITE);
        // Draw the surfaceview background color
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(4);
        canvas.drawBitmap(resizedBitmap, 0, 0, null);
        canvas.drawLine(650, 110, circleX, circleY, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.WHITE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the rectangle.
        // Draw the circle.
        /*if(thisX<600 && thisY<420) {
            ((TextView) findViewById(R.id.textview1)).setText("New Text");
        }*/
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(4);
        canvas.drawBitmap(resizedBitmap1, 0, 0, null);
        canvas.drawLine(thisX, thisY, circleX, circleY, paint);
        //canvas.drawRect(circleX, circleY, circleX + 200, circleY + 200, paint);
        //if line reaches point x y then print out text of distance traveled!
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

