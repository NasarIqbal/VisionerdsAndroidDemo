package com.nasar.visionerdsdemo.ui.base

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewBaseFragment : BaseFragment() {

    companion object {
        private var TAG: String = RecyclerViewBaseFragment::class.java.name
    }

    protected open fun setUpRecyclerView(pRecyclerView: RecyclerView) {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        pRecyclerView.layoutManager = linearLayoutManager
        pRecyclerView.itemAnimator = DefaultItemAnimator()
        val mAdapter: RecyclerView.Adapter<*> = onPrepareAdapter()
        pRecyclerView.adapter = mAdapter
    }

    protected abstract fun onPrepareAdapter(): RecyclerView.Adapter<*>
}