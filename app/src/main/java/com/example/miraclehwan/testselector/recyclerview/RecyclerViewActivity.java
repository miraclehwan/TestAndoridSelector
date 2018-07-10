package com.example.miraclehwan.testselector.recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.miraclehwan.testselector.R;
import com.example.miraclehwan.testselector.databinding.RecyclerviewMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miraclehwan on 2018-07-08.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerviewMainBinding binding;

    List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.recyclerview_main);

        datas.add("첫번째");
        datas.add("두번째");
        datas.add("세번째");
        datas.add("네번째");
        datas.add("첫번째");
        datas.add("두번째");
        datas.add("세번째");
        datas.add("네번째");
        datas.add("첫번째");
        datas.add("두번째");
        datas.add("세번째");
        datas.add("네번째");        datas.add("첫번째");
        datas.add("두번째");
        datas.add("세번째");
        datas.add("네번째");


        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new MyRecyclerViewAdapter(this, datas));
    }
}
