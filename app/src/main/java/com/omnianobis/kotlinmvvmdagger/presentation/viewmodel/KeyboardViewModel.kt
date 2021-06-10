package com.omnianobis.kotlinmvvmdagger.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.omnianobis.kotlinmvvmdagger.common.SingleLiveData
import com.omnianobis.kotlinmvvmdagger.common.event.StateEvent
import javax.inject.Inject

class KeyboardViewModel @Inject constructor() : ViewModel() {

    val keyboardEvent: SingleLiveData<StateEvent> = SingleLiveData()

    fun showKeyboard() {
        keyboardEvent.value = StateEvent.SHOW
    }

    fun hideKeyboard() {
        keyboardEvent.value = StateEvent.HIDE
    }
}