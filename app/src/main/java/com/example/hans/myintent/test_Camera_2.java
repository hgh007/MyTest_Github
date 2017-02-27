package com.example.hans.myintent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class test_Camera_2 extends Activity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView id_ImageView;

    Button id_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__camera_2);

        id_Button = (Button) findViewById(R.id.id_Button);
        id_ImageView = (ImageView) findViewById(R.id.id_ImageView);

        if (!hasCamera())
            id_Button.setEnabled(false);
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void cmbLunchCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            id_ImageView.setImageBitmap(photo);
        }
    }



}
