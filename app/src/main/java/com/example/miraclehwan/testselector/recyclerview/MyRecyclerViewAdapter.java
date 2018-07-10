package com.example.miraclehwan.testselector.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miraclehwan.testselector.databinding.ItemRecyclerviewBinding;

import java.util.List;

/**
 * Created by miraclehwan on 2018-07-08.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    List<String> datas;
    int[] selectedList;

    public MyRecyclerViewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        selectedList = new int[datas.size()];
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

//        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((MyViewHolder) holder).binding.itemRecyclerViewParentLayout.getLayoutParams();
//        if (selectedList[position] == 0){
//            layoutParams.height = ((MyViewHolder) holder).binding.itemRecyclerViewTextView.getHeight();
//        }else{
//            layoutParams.height = layoutParams.height * 2;
//        }
//        ((MyViewHolder) holder).binding.itemRecyclerViewParentLayout.setLayoutParams(layoutParams);

        ((MyViewHolder) holder).bind(position);


        ((MyViewHolder) holder).binding.itemRecyclerViewTextView.setText(datas.get(position) + " 바인딩으로 수정");

        ((MyViewHolder) holder).binding.itemRecyclerViewParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((MyViewHolder) holder).binding.itemRecyclerViewParentLayout.getLayoutParams();
                if (selectedList[position] == 0){
                    selectedList[position] = 1;
                    layoutParams.height = layoutParams.height * 2;
                }else{
                    selectedList[position] = 0;
                    layoutParams.height = ((MyViewHolder) holder).binding.itemRecyclerViewTextView.getHeight();
                }
                ((MyViewHolder) holder).binding.itemRecyclerViewParentLayout.setLayoutParams(layoutParams);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemRecyclerviewBinding binding;

        public MyViewHolder(ItemRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position){
            if (selectedList[position] == 1){
                if (binding.itemRecyclerViewTextView.getHeight() == binding.itemRecyclerViewParentLayout.getHeight()){
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) binding.itemRecyclerViewParentLayout.getLayoutParams();
                    layoutParams.height = layoutParams.height * 2;
                    binding.itemRecyclerViewParentLayout.setLayoutParams(layoutParams);
                }
            }else{
                if (binding.itemRecyclerViewParentLayout.getHeight() != 0){
                    if (binding.itemRecyclerViewTextView.getHeight() != binding.itemRecyclerViewParentLayout.getHeight()){
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) binding.itemRecyclerViewParentLayout.getLayoutParams();
                        layoutParams.height = layoutParams.height / 2;
                        binding.itemRecyclerViewParentLayout.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }
}
