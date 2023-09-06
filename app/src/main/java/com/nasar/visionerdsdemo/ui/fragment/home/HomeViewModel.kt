package com.nasar.visionerdsdemo.ui.fragment.home

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.nasar.visionerdsdemo.data.enums.Result
import com.nasar.visionerdsdemo.data.enums.ResultLiveData
import com.nasar.visionerdsdemo.model.Beneficiary
import com.nasar.visionerdsdemo.ui.base.BaseViewModel
import com.nasar.visionerdsdemo.utils.BeneficiaryJsonParser
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private var beneficiaryList:ArrayList<Beneficiary>? = null
    private val context = application
    val liveData = ResultLiveData<MutableList<Any>>()


     fun initializeList(){
        viewModelScope.launch {
            beneficiaryList = BeneficiaryJsonParser.parseJson(context,"beneficiaries.json")
            val list = mutableListOf<Any>()
            for (item in beneficiaryList ?: emptyList()){
                list.add(item)
            }
            liveData.value = Result.Success(list)
        }
    }
}