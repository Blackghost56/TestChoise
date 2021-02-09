package com.testchoise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.testchoise.databinding.UserItemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder.ViewHolderUser> {

    List<UserModel> mItemsList;
    Context mContext;
    int mItemLayout;

    public Adapter(Context context, List<UserModel> itemsList, int itemLayout){
        mContext = context;
        mItemsList = itemsList;
        mItemLayout = itemLayout;
    }

    @NonNull
    @Override
    public ViewHolder.ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserItemBinding binding = DataBindingUtil.inflate(inflater, mItemLayout, parent, false);
        return new ViewHolder.ViewHolderUser(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder.ViewHolderUser holder, int position) {
        holder.bind(mItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }
}
