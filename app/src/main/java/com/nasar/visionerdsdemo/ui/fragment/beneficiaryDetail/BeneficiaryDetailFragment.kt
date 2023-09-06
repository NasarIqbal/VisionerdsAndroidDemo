package com.nasar.visionerdsdemo.ui.fragment.beneficiaryDetail

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nasar.visionerdsdemo.R
import com.nasar.visionerdsdemo.databinding.FragmentBeneficiaryDetailBinding
import com.nasar.visionerdsdemo.model.Beneficiary
import com.nasar.visionerdsdemo.ui.base.BaseFragment
import com.nasar.visionerdsdemo.utils.CommonKeys

class BeneficiaryDetailFragment : BaseFragment() {

    companion object {
        fun newInstance(beneficiary: Beneficiary) = BeneficiaryDetailFragment().apply {
            val args = Bundle()
            args.putParcelable(CommonKeys.KEY_DATA,beneficiary)
            this.arguments = args
        }
    }

    private val viewModel: BeneficiaryDetailViewModel by lazy {
        ViewModelProvider(this)[BeneficiaryDetailViewModel::class.java]
    }

    private lateinit var mBinding:FragmentBeneficiaryDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentBeneficiaryDetailBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            viewModel.beneficiary = arguments?.getParcelable(CommonKeys.KEY_DATA,Beneficiary::class.java)
            mBinding.data = viewModel.beneficiary
            mBinding.executePendingBindings()
        }else{
            viewModel.beneficiary = arguments?.getParcelable(CommonKeys.KEY_DATA)
        }
    }

}