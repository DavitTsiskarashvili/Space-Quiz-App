package com.example.corecommon.common.mapper

interface Mapper<in ModelA, out ModelB> {
    operator fun invoke(model: ModelA): ModelB
}