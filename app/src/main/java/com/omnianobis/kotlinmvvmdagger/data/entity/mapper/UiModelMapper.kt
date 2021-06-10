package com.omnianobis.kotlinmvvmdagger.data.entity.mapper

import com.omnianobis.kotlinmvvmdagger.data.entity.db.ItemDBModel
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel

object UiModelMapper {

    fun map(model: ItemDBModel): ItemUIModel = ItemUIModel(model.id, model.name)
}