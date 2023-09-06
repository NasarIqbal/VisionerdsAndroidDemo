package com.nasar.visionerdsdemo.ui.fragment.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nasar.visionerdsdemo.R
import com.nasar.visionerdsdemo.data.adapter.RecyclerViewAdapter
import com.nasar.visionerdsdemo.data.enums.Result
import com.nasar.visionerdsdemo.databinding.FragmentHomeBinding
import com.nasar.visionerdsdemo.model.Beneficiary
import com.nasar.visionerdsdemo.ui.activity.rootActivity.MainActivityImp
import com.nasar.visionerdsdemo.ui.base.BaseFragment
import com.nasar.visionerdsdemo.ui.base.RecyclerViewBaseFragment

class HomeFragment : RecyclerViewBaseFragment(),RecyclerViewAdapter.CallBack {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val mViewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    private lateinit var mBinding:FragmentHomeBinding
    private lateinit var mActivityListener: MainActivityImp
    private lateinit var mAdapter:RecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mActivityListener = context as MainActivityImp
        } catch (ex: ClassCastException) {
            ex.printStackTrace()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.liveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    mBinding.progressBar.visibility = View.GONE
                }
                is Result.Loading -> {
                    mBinding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    mBinding.progressBar.visibility = View.GONE
                    mAdapter = RecyclerViewAdapter(this, result.data as ArrayList<Any>)
                    setUpRecyclerView(mBinding.beneficiaries)
                }
            }

        }

        mViewModel.initializeList()

    }

    override fun onPrepareAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun inflateLayoutFromId(position: Int, data: Any?): Int {
        return R.layout.item_beneficiary
    }

    override fun onItemClick(data: Any?, position: Int) {
        super.onItemClick(data, position)
        mActivityListener.openBeneficiariesDetail(data as Beneficiary)
    }

    override fun onNoDataFound() {
        mBinding.beneficiaries.visibility = View.GONE
        mBinding.noDataFound.visibility = View.VISIBLE
    }

    override fun onDataFound() {
        mBinding.noDataFound.visibility = View.GONE
        mBinding.beneficiaries.visibility = View.VISIBLE
    }

}