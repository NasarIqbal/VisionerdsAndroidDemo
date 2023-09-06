package com.nasar.visionerdsdemo.data.adapter

import android.view.View

class RecyclerViewAdapter(
    private val mAdapterCallBack: CallBack,
    private val mData: ArrayList<Any>
) : BaseAdapter() {
    override fun onItemLongClick(view: View, data: Any?, position: Int): Boolean {
        if (IsOnClickEnable()) {
            mAdapterCallBack.onItemLongClick(view, data, position)
        }
        return true
    }

    override fun getObjForPosition(position: Int): Any {
        return mData[position]
    }

    override fun itemOnClick(data: Any?, position: Int) {
        if (IsOnClickEnable()) {
            mAdapterCallBack.onItemClick(data, position)
        }
    }

    override fun getItemCount(): Int {
        return when (mData.size) {
            0 -> {
                mAdapterCallBack.onNoDataFound()
                0
            }
            else -> {
                mAdapterCallBack.onDataFound()
                mData.size
            }
        }

    }

    override fun onViewClick(view: View, data: Any) {
        mAdapterCallBack.onViewClicked(view, data)
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return mAdapterCallBack.inflateLayoutFromId(position, mData[position])
    }

    fun isItemClickAble(isEnable: Boolean) {
        IsOnClickEnable(isEnable)
    }

    interface CallBack {
        fun onViewClicked(view: View, data: Any?) {

        }

        fun onItemClick(data: Any?, position: Int) {

        }

        fun onItemLongClick(view: View, data: Any?, position: Int) {

        }

        fun inflateLayoutFromId(position: Int, data: Any?): Int
        fun onNoDataFound()
        fun onDataFound()
    }

    companion object {
        private const val TAG = "RecyclerViewAdapter"
    }

}