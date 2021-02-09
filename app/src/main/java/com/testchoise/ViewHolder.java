package com.testchoise;


import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.testchoise.databinding.UserItemBinding;


public class ViewHolder<VDB extends ViewDataBinding, IM extends ItemModel> extends RecyclerView.ViewHolder {

    IM mItem;

    public ViewHolder(VDB binding) {
        super(binding.getRoot());
    }

    public void bind(IM itemModel){
        mItem = itemModel;
    }


    public static class ViewHolderUser extends ViewHolder<UserItemBinding, UserModel> {

        UserItemBinding mBinding;

        public ViewHolderUser(UserItemBinding binding) {
            super(binding);
            mBinding = binding;
        }

        public void bind(UserModel itemModel){
            mBinding.setModel(itemModel);
        }
    }
}
