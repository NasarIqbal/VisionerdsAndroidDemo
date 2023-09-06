package com.nasar.visionerdsdemo.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


abstract class BaseFragment : Fragment() {
    companion object {
        val TAG = BaseFragment::class.java.name
    }

}