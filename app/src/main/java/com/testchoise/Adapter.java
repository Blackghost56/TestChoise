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

public class Adapter<VH extends ViewHolder<UserItemBinding, UserModel>> extends RecyclerView.Adapter<VH> {

    public interface Factory<VH>{
        public VH build(UserItemBinding binding);
    }

    private final Factory<VH> mFactory;

    List<UserModel> mItemsList;
    Context mContext;
    int mItemLayout;

    public Adapter(Context context, List<UserModel> itemsList, int itemLayout, Factory<VH> factory){
        mContext = context;
        mItemsList = itemsList;
        mItemLayout = itemLayout;
        mFactory = factory;
    }



    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserItemBinding binding = DataBindingUtil.inflate(inflater, mItemLayout, parent, false);
//        return new VH(binding);
        return mFactory.build(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(mItemsList.get(position));
    }

//    @NonNull
//    @Override
//    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        UserItemBinding binding = DataBindingUtil.inflate(inflater, mItemLayout, parent, false);
//        return new ViewHolderUser(binding);
//    }


//    @Override
//    public void onBindViewHolder(@NonNull ViewHolderUser holder, int position) {
//        holder.bind(mItemsList.get(position));
//    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }
}
