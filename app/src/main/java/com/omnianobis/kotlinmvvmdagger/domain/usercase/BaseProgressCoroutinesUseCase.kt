package com.omnianobis.kotlinmvvmdagger.domain.usercase

import com.omnianobis.kotlinmvvmdagger.domain.repository.IProgressRepository
import javax.inject.Inject

abstract class BaseProgressCoroutinesUseCase<T> : BaseCoroutinesUseCase<T>() {

    @Inject
    lateinit var progressRepository: IProgressRepository

    override fun executePreBackground() {
        progressRepository.showProgressBar(this)
    }

    override fun executePostBackground() {
        progressRepository.hideProgressBar(this)
    }
}