package com.example.miraclehwan.testselector;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miraclehwan.testselector.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int currentPosition = R.id.menu1_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.menu1Layout.setOnClickListener(clickListener);
        binding.menu2Layout.setOnClickListener(clickListener);
        binding.menu3Layout.setOnClickListener(clickListener);

        SetSelect(binding.menu1Textview, binding.menu1Imageview);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentPosition != v.getId()){
                if (currentPosition == R.id.menu1_layout){
                    SetunSelect(binding.menu1Textview, binding.menu1Imageview);
                }else if (currentPosition == R.id.menu2_layout){
                    SetunSelect(binding.menu2Textview, binding.menu2Imageview);
                }else if (currentPosition == R.id.menu3_layout){
                    SetunSelect(binding.menu3Textview, binding.menu3Imageview);
                }

                if (v.getId() == R.id.menu1_layout){
                    SetSelect(binding.menu1Textview, binding.menu1Imageview);
                }else if (v.getId() == R.id.menu2_layout){
                    SetSelect(binding.menu2Textview, binding.menu2Imageview);
                }else if (v.getId() == R.id.menu3_layout){
                    SetSelect(binding.menu3Textview, binding.menu3Imageview);
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
