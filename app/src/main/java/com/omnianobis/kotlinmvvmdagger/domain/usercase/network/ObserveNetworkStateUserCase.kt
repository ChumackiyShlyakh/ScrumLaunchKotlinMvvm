package com.omnianobis.kotlinmvvmdagger.domain.usercase.network

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.common.event.NetworkStateEvent
import com.omnianobis.kotlinmvvmdagger.domain.repository.INetworkStateRepository
import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseObserveUseCase
import javax.inject.Inject

class ObserveNetworkStateUserCase @Inject constructor(
    private val networkStateRepository: INetworkStateRepository
) : BaseObserveUseCase<NetworkStateEvent>() {

    override fun observe(): LiveData<NetworkStateEvent> =
        networkStateRepository.observeNetworkConnectionState()
}