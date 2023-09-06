package com.nasar.visionerdsdemo.data.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.nasar.visionerdsdemo.data.interfaces.AdapterOnClick
import com.nasar.visionerdsdemo.BR

class BaseViewHolder(private val mBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(mBinding.root) {

    fun bind(obj: Any?, callBack: AdapterOnClick) {
        mBinding.setVariable(BR.obj, obj)
        mBinding.executePendingBindings()
    }
}