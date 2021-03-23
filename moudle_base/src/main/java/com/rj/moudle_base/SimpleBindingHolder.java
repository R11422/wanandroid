package com.rj.moudle_base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;


/**
 * author: luqihua
 * date:2020/4/9
 * description:
 **/
public class SimpleBindingHolder<T extends ViewBinding> extends RecyclerView.ViewHolder {
    private final T _binding;

    public SimpleBindingHolder(T viewBinding) {
        super(viewBinding.getRoot());
        this._binding = viewBinding;
    }

    public T getBinding() {
        return _binding;
    }
}
