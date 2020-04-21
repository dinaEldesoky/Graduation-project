/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.gms.samples.vision.ocrreader;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import 	android.graphics.Point;

import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import java.util.List;






/**
 * Graphic instance for rendering TextBlock position, size, and ID within an associated graphic
 * overlay view.
 */

public class OcrGraphic extends GraphicOverlay.Graphic  {
    public GraphicOverlay<OcrGraphic> graphicOverlay;
    private int id;

    private static final int TEXT_COLOR = Color.BLACK;
    private static final int Background_color = Color.WHITE;
//public String c1,c2,c3,c4;
public String c1x,c1y,c2x,c2y,c3x, c3y,c4x,c4y;
   private static Paint rectPaint;
   //private static Paint recttt = new Paint();
    private static Paint textPaint;
    private static final String API_KEY = "AIzaSyDhltiJFo3AY_lkYWB4_z56H3rzwEC-jbg";
    private final TextBlock textBlock;
    //////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////
    OcrGraphic(GraphicOverlay overlay, TextBlock text) {
        super(overlay);

        textBlock = text;

Point[] coordinates = text.getCornerPoints();

       // c1= coordinates[0].toString();
      //  c2= coordinates[1].toString();
      //  c3= coordinates[2].toString();
       // c4= coordinates[3].toString();


        if (rectPaint == null) {
            rectPaint = new Paint();
           rectPaint.setColor(Background_color);

          rectPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //  rectPaint.setShadowLayer(30,0,0, Color.BLUE);
          //  rectPaint.setMaskFilter(new BlurMaskFilter(1000, BlurMaskFilter.Blur.INNER));
            rectPaint.setStrokeWidth(0.0f);

        }

        if (textPaint == null) {
            textPaint = new Paint();
            textPaint.setColor(TEXT_COLOR);
            textPaint.setTextSize(90);
        }
        // Redraw the overlay, as this graphic has been added.
        postInvalidate();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextBlock getTextBlock() {
        //////////////////////////////////////




        return textBlock;
    }

    /**
     * Checks whether a point is within the bounding box of this graphic.
     * The provided point should be relative to this graphic's containing overlay.
     * @param x An x parameter in the relative context of the canvas.
     * @param y A y parameter in the relative context of the canvas.
     * @return True if the provided point is contained within this graphic's bounding box.
     */
    public boolean contains(float x, float y) {
        if (textBlock == null) {
            return false;
        }
        RectF rect = new RectF(textBlock.getBoundingBox());
        rect = translateRect(rect);
        return rect.contains(x, y);
    }

    /**
     * Draws the text block annotations for position, size, and raw value on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        if (textBlock == null) {
            return;
        }



        RectF rect = new RectF(textBlock.getBoundingBox());

        rect = translateRect(rect);
//rectPaint.setMaskFilter(new BlurMaskFilter(3000000, BlurMaskFilter.Blur.INNER));

        canvas.drawRect(rect, rectPaint);
////////////////////////////////////////////////////////////////////


        //TranslateOptions options = TranslateOptions.newBuilder().setApiKey(API_KEY).build();
        //Translate translate = options.getService();

        //final Translation translation = translate.translate(textBlock.getValue(),Translate.TranslateOption.targetLanguage("ar"));
        //////////////////////////////////////////////////////////
        //Bitmap bitmap = Bitmap.createBitmap((int)rect.width(),(int)rect.height(), Bitmap.Config.ARGB_8888);



        //////////////////////////////////////////////////////////////////////
        List<? extends Text> textComponents = textBlock.getComponents();

        for(Text currentText : textComponents) {
            float left = translateX(currentText.getBoundingBox().left);
            float right = translateX(currentText.getBoundingBox().right);
            float bottom = translateY(currentText.getBoundingBox().bottom);
            float top = translateY(currentText.getBoundingBox().top);
            float center = translateY(currentText.getBoundingBox().centerY());
            float centerx = translateX(currentText.getBoundingBox().centerX());



          //  canvas.drawText(c1,left,bottom,textPaint);
          //  canvas.drawText(c2,right,bottom,textPaint);
          //  canvas.drawText(c3,right,top,textPaint);
          //  canvas.drawText(c4,left,top,textPaint);
         canvas.drawText(currentText.getValue(),left,bottom,  textPaint);
           // canvas.drawBitmap(bitmap,left, top, rectPaint);
        }


    }
}
