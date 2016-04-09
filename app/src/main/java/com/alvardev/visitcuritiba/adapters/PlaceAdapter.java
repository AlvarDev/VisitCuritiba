package com.alvardev.visitcuritiba.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvardev.visitcuritiba.R;
import com.alvardev.visitcuritiba.entities.PlaceEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>
        implements View.OnClickListener{

    private List<PlaceEntity> mData;
    private View.OnClickListener listener;
    private Context context;

    public PlaceAdapter(List<PlaceEntity> myData, Context context) {
        this.mData = myData;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPicture;
        public TextView tvName;
        public TextView tvAddress;

        public ViewHolder(View v) {
            super(v);
            ivPicture = (ImageView)v.findViewById(R.id.iv_picture);
            tvName = (TextView)v.findViewById(R.id.tv_name);
            tvAddress = (TextView)v.findViewById(R.id.tv_address);
        }
    }

    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_place, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(mData.get(position).getUrlImage())
                .placeholder(R.drawable.img_curitiba)
                .into(holder.ivPicture);
        holder.tvName.setText(mData.get(position).getName());
        holder.tvAddress.setText(mData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


}