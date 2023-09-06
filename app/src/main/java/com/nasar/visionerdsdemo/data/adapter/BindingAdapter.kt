package com.nasar.visionerdsdemo.data.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.nasar.visionerdsdemo.R
import com.nasar.visionerdsdemo.model.BeneficiaryAddress

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("setDesignation")
    fun setDesignation(textView: TextView, designation: String?) {
        textView.text = when(designation){
            "P" -> {
                textView.context.getString(R.string.primary)
            }
            "C" -> {
                textView.context.getString(R.string.contingent)
            }
            else -> {
                textView.context.getString(R.string.primary)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("setAddress")
    fun setAddress(textView: TextView, address: BeneficiaryAddress?) {
        textView.text = "${address?.firstLineMailing},${address?.scndLineMailing},${address?.city},${address?.country}"
    }
}