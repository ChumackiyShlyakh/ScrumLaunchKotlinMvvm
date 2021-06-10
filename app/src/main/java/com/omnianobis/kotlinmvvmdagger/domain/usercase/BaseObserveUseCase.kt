package com.omnianobis.kotlinmvvmdagger.domain.usercase

import androidx.lifecycle.LiveData

abstract class BaseObserveUseCase<T> {

    abstract fun observe(): LiveData<T>
}