package com.omnianobis.kotlinmvvmdagger.data.entity.mapper

import com.omnianobis.kotlinmvvmdagger.data.entity.db.ItemDBModel
import com.omnianobis.kotlinmvvmdagger.data.entity.network.ItemResponse
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel

object DbModelMapper {

    fun map(model: ItemResponse): ItemDBModel = ItemDBModel(model.id, model.name)

    fun map(model: ItemUIModel): ItemDBModel = ItemDBModel(model.id, model.name)
}