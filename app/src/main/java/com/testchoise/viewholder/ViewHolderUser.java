package com.testchoise.viewholder;

import com.testchoise.UserModel;
import com.testchoise.databinding.UserItemBinding;

public class ViewHolderUser extends ViewHolder<UserItemBinding, UserModel> {

    UserItemBinding mBinding;

    public ViewHolderUser(UserItemBinding binding) {
        super(binding);
        mBinding = binding;
    }

    public void bind(UserModel itemModel){
        mBinding.setModel(itemModel);
    }
}