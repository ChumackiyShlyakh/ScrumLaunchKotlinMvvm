package com.omnianobis.kotlinmvvmdagger.presentation.viewmodel

import androidx.lifecycle.Observer
import com.omnianobis.kotlinmvvmdagger.common.SingleLiveData
import com.omnianobis.kotlinmvvmdagger.common.event.StateEvent
import com.omnianobis.kotlinmvvmdagger.domain.usercase.network.ObserveNetworkStateUserCase
import com.omnianobis.kotlinmvvmdagger.domain.usercase.progress.ObserveProgressUserCase

abstract class BaseProgressViewModel(
    observeProgressUserCase: ObserveProgressUserCase,
    observeNetworkStateUserCase: ObserveNetworkStateUserCase? = null
) : BaseViewModel(observeNetworkStateUserCase) {

    val progressGlobalEvent = SingleLiveData<StateEvent>()

    private val progressObserve = Observer<StateEvent> {
        progressGlobalEvent.value = it
    }

    init {
        observeProgressUserCase.apply { observe().observeForever(progressObserve) }
    }
}