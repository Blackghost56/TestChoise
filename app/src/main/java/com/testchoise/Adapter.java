package com.testchoise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.testchoise.viewholder.ViewHolder;

import java.util.List;

public class Adapter<VDB extends ViewDataBinding, IM extends ItemModel, VH extends ViewHolder<VDB, IM>> extends RecyclerView.Adapter<VH> {

    private final ViewHolder.Factory<VH, VDB> mFactory;

    List<IM> mItemsList;
    Context mContext;
    int mItemLayout;

    public Adapter(Context context, List<IM> itemsList, int itemLayout, ViewHolder.Factory<VH, VDB> factory){
        mContext = context;
        mItemsList = itemsList;
        mItemLayout = itemLayout;
        mFactory = factory;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VDB binding = DataBindingUtil.inflate(inflater, mItemLayout, parent, false);
        return mFactory.build(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(mItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }
}
