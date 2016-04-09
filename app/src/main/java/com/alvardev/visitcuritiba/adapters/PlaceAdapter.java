package com.alvardev.visitcuritiba.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvardev.visitcuritiba.R;
import com.alvardev.visitcuritiba.entities.PlaceEntity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>
        implements View.OnClickListener{

    private List<PlaceEntity> mData;
    private View.OnClickListener listener;

    public PlaceAdapter(List<PlaceEntity> myData) {
        mData = myData;
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
        holder.ivPicture.setImageResource(mData.get(position).getIdImage());
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