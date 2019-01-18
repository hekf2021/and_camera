package com.example.administrator.and_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    //意图回传值的结果码
    private final int IMAGE_RESULT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.button);
        imageView = (ImageView)this.findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,IMAGE_RESULT_CODE);
            }
        });
    }

    //使用意图的回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        System.out.println("1111111111111111111");
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==IMAGE_RESULT_CODE&&resultCode ==RESULT_OK){
            System.out.println("22222222222222222");
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
