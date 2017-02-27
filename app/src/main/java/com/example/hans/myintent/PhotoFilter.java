package com.example.hans.myintent;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class PhotoFilter extends AppCompatActivity {

    ImageView imageViewface;
    Drawable testface;
    Bitmap bitmapImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_filter);

        imageViewface = (ImageView) findViewById(R.id.id_imageViewFace);
        testface = getResources().getDrawable(R.drawable.face);


    /*    Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.face);
        layers[1] = getResources().getDrawable(R.drawable.backrond);


        LayerDrawable layerDrawable = new LayerDrawable(layers);
        imageViewface.setImageDrawable(layerDrawable);

*/


        bitmapImage = ((BitmapDrawable) testface).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        imageViewface.setImageBitmap(newPhoto);

        MediaStore.Images.Media.insertImage(getContentResolver(),newPhoto,"title", "description");
    }

    public static Bitmap invertImage(Bitmap original){

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

        int A,R,G,B;
        int pixelColor;

        int height = original.getHeight();
       // int width = original.getWidth();
        int width = 350;


        for (int  y= 0; y < height; y++ ) {

            for (int  x= 0; x < width; x++ ) {
                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R=  255-Color.red(pixelColor);
                G = 255- Color.green(pixelColor);
                B = 255-Color.blue(pixelColor);
                finalImage.setPixel(x,y, Color.argb(A,R,G,B));
            }

        }

/*
       width = original.getWidth() ;
        // width =   width - 350;


        for (int  y= 0; y < height; y++ ) {

            for (int  x= 350; x < width; x++ ) {
                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R=  Color.red(pixelColor);
                G = Color.green(pixelColor);
                B = Color.blue(pixelColor);
                finalImage.setPixel(x,y, Color.argb(A,R,G,B));
            }

        }*/
return  finalImage;
    }

}
