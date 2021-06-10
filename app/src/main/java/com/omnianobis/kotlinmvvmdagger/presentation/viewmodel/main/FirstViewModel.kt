package com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main

import androidx.lifecycle.Observer
import com.omnianobis.kotlinmvvmdagger.common.Navigate
import com.omnianobis.kotlinmvvmdagger.common.SingleLiveData
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel
import com.omnianobis.kotlinmvvmdagger.domain.usercase.item.GetItemsUseCase
import com.omnianobis.kotlinmvvmdagger.domain.usercase.item.ObserveItemsUseCase
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    getItemsUseCase: GetItemsUseCase,
    observeItemsUseCase: ObserveItemsUseCase
): BaseViewModel() {

    val itemsLiveData = SingleLiveData<List<ItemUIModel>>()

    private val itemsObserver = Observer<List<ItemUIModel>> {
        itemsLiveData.value = it
    }

    init {
        getItemsUseCase.execute {
            onComplete {
                itemsLiveData.value = it
            }

            onNetworkError { Timber.e(it.toString()) }
            onError { Timber.e(it) }
        }

        observeItemsUseCase.observe().observeForever(itemsObserver)
    }

    fun onSecondPageClicked(){
        navigateTo(Navigate.Global.SecondPage)
    }
}