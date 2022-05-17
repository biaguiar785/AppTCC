package com.example.autolens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView myImage;
    private Button bt_camera, bt_gallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage= findViewById(R.id.myImageView);
        bt_camera = findViewById(R.id.bt_camera);
        bt_gallery = findViewById(R.id.bt_gallery);

        bt_camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                takePicture();
            }
        });
    }

    private void takePicture() {
    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(i,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK){
            Bitmap b = (Bitmap)data.getExtras().get("data");
            myImage.setImageBitmap(b);
        }
    }
}
