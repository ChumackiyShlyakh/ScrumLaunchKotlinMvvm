package com.omnianobis.kotlinmvvmdagger.domain.usercase.block

import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseCoroutinesUseCase

typealias CompletionBlock<T> = BaseCoroutinesUseCase.Request<T>.() -> Unit