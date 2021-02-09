package com.testchoise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.testchoise.databinding.UserItemBinding;
import com.testchoise.viewholder.ViewHolder;
import com.testchoise.viewholder.ViewHolderUser;

import java.util.List;

public class Adapter<UIB extends ViewDataBinding, UM extends ItemModel, VH extends ViewHolder<UIB, UM>> extends RecyclerView.Adapter<VH> {

    public interface Factory<VH, UIB>{
        public VH build(UIB binding);
    }

    private final Factory<VH, UIB> mFactory;

    List<UM> mItemsList;
    Context mContext;
    int mItemLayout;

    public Adapter(Context context, List<UM> itemsList, int itemLayout, Factory<VH, UIB> factory){
        mContext = context;
        mItemsList = itemsList;
        mItemLayout = itemLayout;
        mFactory = factory;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UIB binding = DataBindingUtil.inflate(inflater, mItemLayout, parent, false);
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
