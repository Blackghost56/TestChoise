package com.testchoise.viewholder;


import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.testchoise.ItemModel;


public abstract class ViewHolder<VDB extends ViewDataBinding, IM extends ItemModel> extends RecyclerView.ViewHolder {

    public ViewHolder(VDB binding) {
        super(binding.getRoot());
    }
    public abstract void bind(IM itemModel);
}
