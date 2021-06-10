package com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main

import com.omnianobis.kotlinmvvmdagger.common.Navigate
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class SecondViewModel @Inject constructor(): BaseViewModel() {

    fun onCloseClicked(){
        navigateTo(Navigate.Global.Close)
    }

}