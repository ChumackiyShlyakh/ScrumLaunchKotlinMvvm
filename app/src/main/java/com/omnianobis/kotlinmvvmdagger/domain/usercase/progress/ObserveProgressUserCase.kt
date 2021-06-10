package com.omnianobis.kotlinmvvmdagger.domain.usercase.progress

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.common.event.StateEvent
import com.omnianobis.kotlinmvvmdagger.domain.repository.IProgressRepository
import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseObserveUseCase
import javax.inject.Inject

class ObserveProgressUserCase @Inject constructor(
    private val progressRepository: IProgressRepository
) : BaseObserveUseCase<StateEvent>() {

    override fun observe(): LiveData<StateEvent> = progressRepository.observeProgressState()
}