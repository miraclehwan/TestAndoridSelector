package com.example.miraclehwan.testselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentPosition = R.id.menu1_layout;

    LinearLayout menu1, menu2, menu3;
    TextView menu1_text, menu2_text, menu3_text;
    ImageView menu1_image, menu2_image, menu3_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu1 = (LinearLayout) findViewById(R.id.menu1_layout);
        menu2 = (LinearLayout) findViewById(R.id.menu2_layout);
        menu3 = (LinearLayout) findViewById(R.id.menu3_layout);

        menu1_text = (TextView) findViewById(R.id.menu1_textview);
        menu2_text = (TextView) findViewById(R.id.menu2_textview);
        menu3_text = (TextView) findViewById(R.id.menu3_textview);

        menu1_image = (ImageView) findViewById(R.id.menu1_imageview);
        menu2_image = (ImageView) findViewById(R.id.menu2_imageview);
        menu3_image = (ImageView) findViewById(R.id.menu3_imageview);

        menu1.setOnClickListener(clickListener);
        menu2.setOnClickListener(clickListener);
        menu3.setOnClickListener(clickListener);

        SetSelect(menu1_text, menu1_image);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentPosition != v.getId()){
                if (currentPosition == R.id.menu1_layout){
                    SetunSelect(menu1_text, menu1_image);
                }else if (currentPosition == R.id.menu2_layout){
                    SetunSelect(menu2_text, menu2_image);
                }else if (currentPosition == R.id.menu3_layout){
                    SetunSelect(menu3_text, menu3_image);
                }

                if (v.getId() == R.id.menu1_layout){
                    SetSelect(menu1_text, menu1_image);
                }else if (v.getId() == R.id.menu2_layout){
                    SetSelect(menu2_text, menu2_image);
                }else if (v.getId() == R.id.menu3_layout){
                    SetSelect(menu3_text, menu3_image);
                }
                currentPosition = v.getId();
            }else{
                Toast.makeText(MainActivity.this, "same position", Toast.LENGTH_SHORT).show();
            }
        }
    };

    void SetSelect(TextView textView, ImageView imageView){
        textView.setSelected(true);
        imageView.setSelected(true);
    }

    void SetunSelect(TextView textView, ImageView imageView){
        textView.setSelected(false);
        imageView.setSelected(false);
    }

}
