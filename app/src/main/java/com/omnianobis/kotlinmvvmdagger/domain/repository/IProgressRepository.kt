package com.omnianobis.kotlinmvvmdagger.domain.repository

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.common.event.StateEvent

interface IProgressRepository {

    fun showProgressBar(obj: Any)
    fun hideProgressBar(obj: Any)
    fun observeProgressState(): LiveData<StateEvent>
}