package com.example.hans.myintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.FaceDetector;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * Created by hans on 23-2-2017.
 */

public class MainActivity extends Activity {
    public View part1, part2;
    int viewHeight, viewWidth;
    private FaceDetector myFaceDetect;
    private FaceDetector.Face[] myFace;
    float myEyesDistance;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        part1 = findViewById(R.id.part1);
        part2 = findViewById(R.id.part2);
        part1.post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                viewHeight = part1.getMeasuredHeight();
                viewWidth = part1.getMeasuredWidth();
                try {

                    Paint paint = new Paint();
                    paint.setFilterBitmap(true);
                    Bitmap bitmapOrg = BitmapFactory.decodeResource(                           getResources(),                            R.drawable.sachin_tendulkar_10102013);

                    int targetWidth = bitmapOrg.getWidth();
                    int targetHeight = bitmapOrg.getHeight();

                    Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                            targetHeight, Bitmap.Config.ARGB_8888);

                    RectF rectf = new RectF(0, 0, viewWidth, viewHeight);

                    Canvas canvas = new Canvas(targetBitmap);
                    Path path = new Path();

                    path.addRect(rectf, Path.Direction.CW);
                    canvas.clipPath(path);

                    canvas.drawBitmap(
                            bitmapOrg,
                            new Rect(0, 0, bitmapOrg.getWidth(), bitmapOrg
                                    .getHeight()), new Rect(0, 0, targetWidth,
                                    targetHeight), paint);

                    Matrix matrix = new Matrix();
                    matrix.postScale(1f, 1f);

                    BitmapFactory.Options bitmapFatoryOptions = new BitmapFactory.Options();
                    bitmapFatoryOptions.inPreferredConfig = Bitmap.Config.RGB_565;

                    bitmapOrg = BitmapFactory.decodeResource(getResources(),
                            R.drawable.sachin_tendulkar_10102013,
                            bitmapFatoryOptions);

                    myFace = new FaceDetector.Face[5];
                    myFaceDetect = new FaceDetector(targetWidth, targetHeight,
                            5);
                    int numberOfFaceDetected = myFaceDetect.findFaces(
                            bitmapOrg, myFace);
                    Bitmap resizedBitmap = null;
                    if (numberOfFaceDetected > 0) {
                        PointF myMidPoint = null;
                        FaceDetector.Face face = myFace[0];
                        myMidPoint = new PointF();
                        face.getMidPoint(myMidPoint);
                        myEyesDistance = face.eyesDistance();

                        if (myMidPoint.x + viewWidth > targetWidth) {
                            while (myMidPoint.x + viewWidth > targetWidth) {
                                myMidPoint.x--;
                            }
                        }
                        if (myMidPoint.y + viewHeight > targetHeight) {
                            while (myMidPoint.y + viewHeight > targetHeight) {
                                myMidPoint.y--;
                            }
                        }
                        resizedBitmap = Bitmap.createBitmap(bitmapOrg,
                                (int) (myMidPoint.x - myEyesDistance),
                                (int) (myMidPoint.y - myEyesDistance),
                                viewWidth, viewHeight, matrix, true);
                    } else {
                        resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,
                                viewWidth, viewHeight, matrix, true);
                    }
                /* convert Bitmap to resource */
                    // Bitmap resizedBitmap = Bitmap.createBitmap(targetBitmap,
                    // 0,
                    // 0, viewWidth, viewHeight, matrix, true);
                    BitmapDrawable bd = new BitmapDrawable(resizedBitmap);

                    part1.setBackgroundDrawable(bd);

                } catch (Exception e) {
                    System.out.println("Error1 : " + e.getMessage()
                            + e.toString());
                }
            }
        });
        part2.post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                viewHeight = part2.getMeasuredHeight();
                viewWidth = part2.getMeasuredWidth();
                try {

                    Paint paint = new Paint();
                    paint.setFilterBitmap(true);
                    Bitmap bitmapOrg = BitmapFactory.decodeResource(
                            getResources(),
                            R.drawable.sachin_tendulkar_10102013);

                    int targetWidth = bitmapOrg.getWidth();
                    int targetHeight = bitmapOrg.getHeight();

                    Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                            targetHeight, Bitmap.Config.ARGB_8888);

                    RectF rectf = new RectF(0, 0, viewWidth, viewHeight);

                    Canvas canvas = new Canvas(targetBitmap);
                    Path path = new Path();

                    path.addRect(rectf, Path.Direction.CW);
                    canvas.clipPath(path);

                    canvas.drawBitmap(
                            bitmapOrg,
                            new Rect(0, 0, bitmapOrg.getWidth(), bitmapOrg
                                    .getHeight()), new Rect(0, 0, targetWidth,
                                    targetHeight), paint);

                    Matrix matrix = new Matrix();
                    matrix.postScale(1f, 1f);

                    BitmapFactory.Options bitmapFatoryOptions = new BitmapFactory.Options();
                    bitmapFatoryOptions.inPreferredConfig = Bitmap.Config.RGB_565;

                    bitmapOrg = BitmapFactory.decodeResource(getResources(),
                            R.drawable.sachin_tendulkar_10102013,
                            bitmapFatoryOptions);

                    myFace = new FaceDetector.Face[5];
                    myFaceDetect = new FaceDetector(targetWidth, targetHeight,
                            5);
                    int numberOfFaceDetected = myFaceDetect.findFaces(
                            bitmapOrg, myFace);
                    Bitmap resizedBitmap = null;
                    if (numberOfFaceDetected > 0) {
                        PointF myMidPoint = null;
                        FaceDetector.Face face = myFace[0];
                        myMidPoint = new PointF();
                        face.getMidPoint(myMidPoint);
                        myEyesDistance = face.eyesDistance() + 20;

                        if (myMidPoint.x + viewWidth > targetWidth) {
                            while (myMidPoint.x + viewWidth > targetWidth) {
                                myMidPoint.x--;
                            }
                        }
                        if (myMidPoint.y + viewHeight > targetHeight) {
                            while (myMidPoint.y + viewHeight > targetHeight) {
                                myMidPoint.y--;
                            }
                        }
                        resizedBitmap = Bitmap.createBitmap(bitmapOrg,
                                (int) (myMidPoint.x - myEyesDistance),
                                (int) (myMidPoint.y - myEyesDistance),
                                viewWidth, viewHeight, matrix, true);
                    } else {
                        resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,
                                viewWidth, viewHeight, matrix, true);
                    }
                /* convert Bitmap to resource */
                    // Bitmap resizedBitmap = Bitmap.createBitmap(targetBitmap,
                    // 0,
                    // 0, viewWidth, viewHeight, matrix, true);
                    BitmapDrawable bd = new  BitmapDrawable(resizedBitmap);

                    part2.setBackgroundDrawable(new BitmapDrawable(
                            getCroppedBitmap(bd.getBitmap())));

                } catch (Exception e) {
                    System.out.println("Error1 : " + e.getMessage()
                            + e.toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        // Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
        // bitmap.getHeight(), Config.ARGB_8888);
        // Canvas canvas = new Canvas(output);
        //
        // final int color = 0xff424242;
        // final Paint paint = new Paint();
        // final Rect rect = new Rect(0, 0, bitmap.getWidth(),
        // bitmap.getHeight());
        //
        // paint.setAntiAlias(true);
        // canvas.drawARGB(0, 0, 0, 0);
        // paint.setColor(color);
        // // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        // canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
        // bitmap.getWidth() / 2, paint);
        // paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        // canvas.drawBitmap(bitmap, rect, rect, paint);
        // // Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        // // return _bmp;
        // return output;

        int targetWidth = bitmap.getWidth();
        int targetHeight = bitmap.getHeight();
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,
                Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth), ((float) targetHeight)) /    2),
                Path.Direction.CCW);


        canvas.clipPath(path);
        Bitmap sourceBitmap = bitmap;
        canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
                sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
                targetHeight), null);
        return targetBitmap;

    }

}