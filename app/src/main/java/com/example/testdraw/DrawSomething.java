package com.example.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class DrawSomething extends View {
    float x,y;
    int radius =70;
    Paint circle, rect;
    float[] top_left={200,300}, bottom_right={400,500};
    public DrawSomething(Context context) {
        super(context);
        rect=new Paint();
        circle = new Paint();
        rect.setColor(Color.BLACK);
        rect.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(top_left[0],top_left[1],bottom_right[0],bottom_right[1],rect);

       /* if ((y-radius<bottom_right[1]&&y-radius>top_left[1]||y+radius<bottom_right[1]&&y+radius>top_left[1])&&
        (x-radius<bottom_right[0]&&x-radius>top_left[0]||x+radius<bottom_right[0]&&x+radius>top_left[0]))*//*||
        isCollision(top_left[0],top_left[1])||isCollision(top_right[0],top_right[1])||
        isCollision(bottom_left[0],bottom_left[1])||isCollision(bottom_right[0],bottom_right[1]))*//*{*/

        if (top_left[1]-radius<y && bottom_right[1]+radius>y && top_left[0]-radius<x && bottom_right[0]+radius>x){
            circle.setColor(Color.RED);
        }
        else circle.setColor(Color.GREEN);

        canvas.drawCircle(x,y,radius,circle);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=event.getX();
        y=event.getY();
        invalidate();
        return true;
    }

}
