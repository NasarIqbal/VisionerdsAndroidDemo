package com.nasar.visionerdsdemo.ui.activity.rootActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nasar.visionerdsdemo.R
import com.nasar.visionerdsdemo.databinding.ActivityMainBinding
import com.nasar.visionerdsdemo.model.Beneficiary
import com.nasar.visionerdsdemo.ui.base.BaseActivity
import com.nasar.visionerdsdemo.ui.fragment.beneficiaryDetail.BeneficiaryDetailFragment
import com.nasar.visionerdsdemo.ui.fragment.home.HomeFragment

class MainActivity : BaseActivity(),MainActivityImp {

    private lateinit var mBinding:ActivityMainBinding
    private val mViewModel:MainActivityViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        replaceFragmentWithoutAddingToBackStack(mBinding.mainContainer.id,HomeFragment.newInstance())
    }

    override fun openBeneficiariesDetail(beneficiary: Beneficiary) {
       replaceFragment(mBinding.mainContainer.id,BeneficiaryDetailFragment.newInstance(beneficiary))
    }

}